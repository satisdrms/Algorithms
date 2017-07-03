package interPrct;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hdfs.DistributedFileSystem;
import org.apache.hadoop.security.UserGroupInformation;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.ford.mssap.common.util.MssapConnectionUtil;

//sort a file based on id in java spark

public class ym_SortFile_id {
	static boolean isWindowsOS = false;
	static String namenode = "hdfs://hpchdd2.hpc.ford.com:8020";
	static String operatingSystem = System.getProperty("os.name");
	static Configuration conf = new Configuration();
	static JavaSparkContext jvsc;
	static SparkConf spconf;

	public static void main(String[] args) {
		settingconfigurationandmakeconnection(namenode, operatingSystem, conf);
	}

	private static void settingconfigurationandmakeconnection(String namenode,
			String operatingSystem, Configuration conf) {
		System.out.println("This is windows OS of type :-->" + operatingSystem);
		// Configuration conf = HBaseConfiguration.create();
		conf.set("hadoop.security.authentication", "kerberos");
		conf.set("fs.defaultFS", namenode);
		conf.set("fs.hdfs.impl", DistributedFileSystem.class.getName());
		conf.set("yarn.resourcemanager.principal",
				"yarn/hpchd1.hpc.ford.com@HPC.FORD.COM");
		conf.set("com.sun.security.auth.module.Krb5LoginModule", "required");
		conf.set("yarn.nodemanager.principal",
				"yarn/hpchd1.hpc.ford.com@HPC.FORD.COM");
		String desktopPath = "/properties/desktop/hadoop";
		conf.addResource(MssapConnectionUtil.class
				.getResourceAsStream(desktopPath + "/core-site.xml"));
		conf.addResource(MssapConnectionUtil.class
				.getResourceAsStream(desktopPath + "/hdfs-site.xml"));
		conf.addResource(MssapConnectionUtil.class
				.getResourceAsStream(desktopPath + "/mapred-site.xml"));
		conf.addResource(MssapConnectionUtil.class
				.getResourceAsStream(desktopPath + "/yarn-site.xml"));
		conf.addResource(MssapConnectionUtil.class
				.getResourceAsStream(desktopPath + "/hive-site.xml"));
		conf.addResource(MssapConnectionUtil.class
				.getResourceAsStream(desktopPath + "/hbase-site.xml"));
		// conf.addResource(ym_SortFile_id.class.getResourceAsStream(desktopPath+
		// "/spark-defaults.conf"));
		System.out.println("Conf......");

		UserGroupInformation.setConfiguration(conf);
		try {
			System.setProperty("hdp.version", "2.5.3.0-37");
			System.setProperty("spark.yarn.keytab",
					"C://Hadoop//iapxhtam.keytab");
			System.setProperty("spark.yarn.principal", "iapxhtam@HPC.FORD.COM");
			System.setProperty("spark.hadoop.yarn.resourcemanager.hostname",
					"hpchdd2.hpc.ford.com");
			System.setProperty("spark.hadoop.yarn.resourcemanager.address",
					"hpchdd2.hpc.ford.com:8050");
			System.setProperty(
					"spark.hadoop.yarn.resourcemanager.scheduler.address",
					"hpchdd2.hpc.ford.com:8030");

			int a = 4;
			UserGroupInformation.loginUserFromKeytab("iapxhtam@HPC.FORD.COM",
					"C://Hadoop//iapxhtam.keytab");

			System.out.println(UserGroupInformation.getCurrentUser());
			System.out.println("Obtained......");

			dohiverelatedstuff();

			spconf = new SparkConf();
			spconf.setMaster("yarn-client");
			spconf.setAppName("DeDup Process");

			// Properties prop = new Properties();
			// InputStream ip = ym_SortFile_id.class
			// .getResourceAsStream("/properties/desktop/hadoop/spark-defaults.conf");
			// try {
			// prop.load(ip);
			// Set<?> keys = prop.keySet();
			// Iterator<?> ix = keys.iterator();
			// while (ix.hasNext()) {
			// String key = ix.next().toString().trim();
			// if (key.equals("") || key.startsWith("#")) {
			// continue;
			// }
			// String value = prop.getProperty(key).trim();
			// if (value.equals(""))
			// continue;
			// spconf.set(key, value);
			// }

			spconf.set("spark.driver.extraJavaOptions",
					"-Dhdp.version=2.5.3.0-37");
			spconf.set(
					"spark.driver.extraLibraryPath",
					"/usr/hdp/current/hadoop-client/lib/native:/usr/hdp/current/hadoop-client/lib/native/Linux-amd64-64");
			spconf.set("spark.dynamicAllocation.cachedExecutorIdleTimeout",
					"1h");
			spconf.set("spark.dynamicAllocation.enabled", "true");
			spconf.set("spark.dynamicAllocation.executorIdleTimeout", "60s");
			spconf.set("spark.dynamicAllocation.initialExecutors", "0");
			spconf.set("spark.dynamicAllocation.maxExecutors", "100");
			spconf.set("spark.dynamicAllocation.minExecutors", "0");
			spconf.set("spark.eventLog.dir", "hdfs:///spark-history");
			spconf.set("spark.eventLog.enabled", "true");
			spconf.set(
					"spark.executor.extraLibraryPath",
					"/usr/hdp/current/hadoop-client/lib/native:/usr/hdp/current/hadoop-client/lib/native/Linux-amd64-64");
			spconf.set("spark.history.fs.logDirectory", "hdfs:///spark-history");
			spconf.set("spark.history.kerberos.enabled", "true");
			spconf.set("spark.history.kerberos.keytab",
					"/etc/hadoop/spark_user.keytab");
			spconf.set("spark.history.kerberos.principal", "spark@HPC.FORD.COM");
			spconf.set("spark.history.provider",
					"org.apache.spark.deploy.yarn.history.YarnHistoryProvider");
			spconf.set("spark.history.ui.port", "18080");
			spconf.set("spark.port.maxRetries", "100");
			spconf.set("spark.shuffle.service.enabled", "true");
			spconf.set("spark.yarn.am.extraJavaOptions",
					"-Dhdp.version=2.5.3.0-37");
			spconf.set("spark.yarn.applicationMaster.waitTries", "10");
			spconf.set("spark.yarn.containerLauncherMaxThreads", "25");
			spconf.set("spark.yarn.driver.memoryOverhead", "384");
			spconf.set("spark.yarn.executor.memoryOverhead", "384");
			spconf.set("spark.yarn.historyServer.address",
					"hpchdd2.hpc.ford.com:18080");
			spconf.set("spark.yarn.preserve.staging.files", "false");
			spconf.set("spark.yarn.queue", "default");
			spconf.set("spark.yarn.scheduler.heartbeat.interval-ms", "5000");
			spconf.set("spark.yarn.services",
					"org.apache.spark.deploy.yarn.history.YarnHistoryService");
			spconf.set("spark.yarn.submit.file.replication", "3");

//			spconf.set("spark.hadoop.yarn.resourcemanager.hostname",
//					"hpchdd2.hpc.ford.com");
//			spconf.set("spark.hadoop.yarn.resourcemanager.address",
//					"hpchdd2.hpc.ford.com:8050");
//
//			spconf.set("spark.hadoop.yarn.resourcemanager.scheduler.address",
//					"hpchdd2.hpc.ford.com:8030");

			spconf.set("spark.executor.cores", "4");
			spconf.set("spark.executor.memory", "8g");
			spconf.set("spark.yarn.queue", "scac");
			// ip.close();

			jvsc = new JavaSparkContext(spconf);

			// } catch (IOException e) {
			// // TODO Auto-generated catch block
			// e.printStackTrace();
			// }
		} catch (Exception e) {
			System.out.println("We have an Exception !!!");
			e.printStackTrace();
		}

	}

	private static void dohiverelatedstuff() {
		Connection conn = null;
		Statement stmt = null;
		String db = "10048_udb_qa_lz_db";
		String connectionName = "jdbc:hive2://hpchdd2.hpc.ford.com:10003/default;principal=hive/hpchdd2.hpc.ford.com@HPC.FORD.COM";
		String driverName = "org.apache.hive.jdbc.HiveDriver";
		try {
			Class.forName(driverName);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(connectionName);
			stmt = conn.createStatement();
			String sql = "show tables in " + db;
			ResultSet res = stmt.executeQuery(sql);
			while (res.next()) {
				System.out.println(res.getString(1));
			}
		} catch (SQLException e) {
			System.out.println("Trying out stuff in Exception...");
			e.printStackTrace();
		}

	}
}

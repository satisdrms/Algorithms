val empFile = "/project/scac/dev/transform_zone/standardized_data/10086_svs/10086_svs_dev_tz_scac_db_1/wokins/sdge/emp.txt"
val deptFile = "/project/scac/dev/transform_zone/standardized_data/10086_svs/10086_svs_dev_tz_scac_db_1/wokins/sdge/dept.txt"

val empRDD = sc.textFile(empFile, 2).cache()
val deptRDD = sc.textFile(deptFile, 2).cache()

val getDept:(String,Int)=>String = (rec: String,pos: Int) => { val recArr=rec.split("\\|"); recArr(pos)}

val empPairRDD=empRDD.map(x=>(getDept(x,1),x))

val deptPairRDD=deptRDD.map(x=>(getDept(x,0),x))

val joinedPairRDD=empPairRDD.join(deptPairRDD)	

val joinedNamePairRDD=joinedPairRDD.map(x=>((x._2._2.split("\\|"))(1),(x._2._1.split("\\|"))(2).toInt))

val avgPairRDD=joinedNamePairRDD.reduceByKey((_+_)/2)

val avgPairRDD=joinedNamePairRDD.mapValues((_, 1)).reduceByKey((x, y) => (x._1 + y._1, x._2 + y._2)).mapValues{ case (sum, count) => (1.0 * sum) / count }
	
	getDept("e1|d1|100",2)
	deptPairRDD.collect.foreach(_=>println(_.1,_.2)

	/s/iapxhtam/svs_feb6/sdge
	 hdfs dfs -rm /project/scac/dev/transform_zone/standardized_data/10086_svs/10086_svs_dev_tz_scac_db_1/wokins/sdge/*
	 hdfs dfs -copyFromLocal *txt /project/scac/dev/transform_zone/standardized_data/10086_svs/10086_svs_dev_tz_scac_db_1/wokins/sdge/

	 val r="e1|d1|100"

	 val rArr=r.split("|");
	 
	 empPairRDD.collect
	 
	 deptPairRDD.collect
	 
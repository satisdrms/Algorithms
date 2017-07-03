package interPrct;

import java.io.File;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JSON_Obj_to_Json {

	public static void main(String[] args) throws JsonGenerationException,
			JsonMappingException, IOException {
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = "{'name' : 'mkyong'}";

		Staff obj = new Staff();
		
		mapper.writeValue(new File("staff.json"), obj);

	}

}

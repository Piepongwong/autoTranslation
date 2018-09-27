import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

public class SortTranslationPerType {
	
	 private Map<String, ArrayList<ArrayList<Object>>> SortedTranslations = new HashMap<String, ArrayList<ArrayList<Object>>>();
	 
	 private List<List<Object>> rows;
	 
	 SortTranslationPerType(List<List<Object>> rows){
		 
		 this.rows = rows;
		 
	 }
	 
	@SuppressWarnings({ "null", "unchecked" })
	public Map<String, ArrayList<ArrayList<Object>>> sort() {
		 
		 ArrayList<ArrayList<Object>> TempList = new ArrayList<ArrayList<Object>>();
		 String file = new String();
		 String noFileSpeficied = "NO_FILE_SPECIFIED";
		 
		 try{
			 for (List row : rows) {		 
				 if(row.size() > 1 && row.get(1) != null && row.get(1) != "" && row.get(1) instanceof String) {
					 file = (String) row.get(1);
					 file = file.toLowerCase(); // make it a bit more flexible to sloppy spreadsheet data
					 if(SortedTranslations.get(file) != null) {
						 SortedTranslations.get(file).add((ArrayList<Object>) row);
					 } 
					 else {
						 SortedTranslations.put(file, new ArrayList<ArrayList<Object>>(row));
					 }
				 } else if (row.get(1) == "" || (row.size() > 1 && row.get(1) == null)){
						if(SortedTranslations.get(noFileSpeficied) == null) {
							 SortedTranslations.put(noFileSpeficied, new ArrayList<ArrayList<Object>>(row));
						 } else {
							 SortedTranslations.get(noFileSpeficied).add((ArrayList<Object>) row);				 
						 }
				 } else if (row.get(1) == null) {
					 System.out.println("Could not sort row" + row.toString());
				 } else {
					 System.out.println("Could not sort read row" + row.toString());
				 }			 
			 }
		 } catch(Exception e) {
			 System.out.println("An error occured" + e);
		 }
		 
		 return SortedTranslations;
		 
	 }
	 
}
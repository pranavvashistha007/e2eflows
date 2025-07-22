package api.pojo;

public class NestedData {
	
	
	private String nestedField ;
	
	
	public NestedData() {};
	
	public NestedData(String nestedField) {
		this.nestedField = nestedField;
	};
	
	public String getNestedField () {
		return nestedField ;
	}
	
	public void setNestedField (String nestedField ) {
		this.nestedField = nestedField;
	}
	
	@Override
	public String toString() {
		return "NestedData{" + 
				"nestedField =" + nestedField + '\''+ '}' ;
	}
}

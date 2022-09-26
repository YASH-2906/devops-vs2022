package com.day12.model;
// modified in feature branch
// modified by feature one
public class DistanceModel {
	String name;
	String city;
	int kms;
	String summary;
	
	
	public DistanceModel() {
			
		}
	
	public DistanceModel(String name, String city, int kms) {
		super();
		this.name = name;
		this.city = city;
		this.kms = kms;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public int getKms() {
		return kms;
	}
	public void setKms(int kms) {
		this.kms = kms;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public int getCostfromJson(String name) throws FileNotFoundException, IOException 
	{
		StringBuilder build = new StringBuilder();
		int cost=0;
		try(BufferedReader buffer = new BufferedReader(new FileReader("C:/Users/YASH CHAUDHARI/Desktop/Traning/Day 12/day12-assignment-YASH-2906/day12/src/costs.json")))
		{
			String str;
			while((str=buffer.readLine()) !=null)
			{
				build.append(str);
			}
			str = build.toString().trim();
			try {
				
				JSONObject json = new JSONObject(str);
				JSONArray array = json.getJSONArray("costs");
				for(int i=0; i < array.length(); i++)   
				{  
					JSONObject object = array.getJSONObject(i);  
					
					if((object.getString("city").toString()).equalsIgnoreCase(name))
							cost = object.getInt("price");
				}  
			
				
			} catch (JSONException e) {
				e.printStackTrace();
				return 0;
			}
		}
		return cost;
	}
	public String getSummaryJSONString(DistanceModel d,int cost) 
	{
		return "{\"name\":\""+ d.getName()+"\",\"city\":\""+ d.getCity()+"\",\"kms\":"+ d.getKms()+",\"cost\":"+ cost+"}";
		
	}
}

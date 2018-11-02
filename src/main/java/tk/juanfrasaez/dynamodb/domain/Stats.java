package tk.juanfrasaez.dynamodb.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Stats")
public class Stats {
	
	private String species;
	private Integer stats;

	@DynamoDBHashKey(attributeName = "species")
	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	@DynamoDBAttribute(attributeName = "stats")
	public Integer getStats() {
		return stats;
	}

	public void setStats(Integer stats) {
		this.stats = stats;
	}
	
	public void increment() {
		this.stats += 1;
	}
}

package tk.juanfrasaez.dynamodb.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

@DynamoDBTable(tableName = "Sample")
public class Sample {
	
	private String dna;
	private String species;

	@DynamoDBHashKey(attributeName = "dna")
	public String getDna() {
		return dna;
	}

	public void setDna(String dna) {
		this.dna = dna;
	}

	@DynamoDBAttribute(attributeName = "species")
	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	@Override
	public String toString() {
		return "Sample [" + dna + ", " + species + "]";
	}
}

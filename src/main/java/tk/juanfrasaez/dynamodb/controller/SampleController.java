package tk.juanfrasaez.dynamodb.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import tk.juanfrasaez.dynamodb.domain.Sample;
import tk.juanfrasaez.dynamodb.domain.Stats;

@RestController
public class SampleController {
	
	private DynamoDBMapper repo = new DynamoDBMapper(AmazonDynamoDBClientBuilder.defaultClient());
	
	@PostMapping("/sample")
	public void saveSample(@RequestBody Sample sample) {
		repo.save(sample);
	}
	
	@PostMapping("/sample/{species}")
	public void saveStats(@PathVariable String species) {
		Stats stats = getStats(species);
		stats.increment();
		repo.save(stats);
	}
	
	@GetMapping("/{species}")
	public Stats getStats(@PathVariable String species) {
		return repo.load(Stats.class, species);
	}
}

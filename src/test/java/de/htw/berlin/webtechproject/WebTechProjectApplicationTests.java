package de.htw.berlin.webtechproject;

import de.htw.berlin.webtechproject.api.Item;
import de.htw.berlin.webtechproject.api.ItemManipulationRequest;
import de.htw.berlin.webtechproject.persistence.ItemEntity;
import de.htw.berlin.webtechproject.service.ItemService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.DisplayName;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class WebTechProjectApplicationTests {

		@DisplayName("Verify GetID")
		@Test
		public void testGetId() {
			Item item = new Item(1, "name", "imageUrl", false, LocalDateTime.now());
			assertEquals(1, item.getId());
		}

		@Autowired
		private TestRestTemplate restTemplate;

		@Autowired
		private ItemService itemService;

		@DisplayName("verify that the fetchItems endpoint returns a list of items from the ItemService")
		@Test
		void testFetchItems() {
		List<Item> expectedItems = itemService.findAll();
		ResponseEntity<List> response = restTemplate.getForEntity("/api/v1/items", List.class);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
		assertThat(response.getBody()).isEqualTo(expectedItems);
	}

		@DisplayName("verifies that the object's properties are set to the expected values")
		@Test
		public void testItemManipulationRequest() {
		String name = "Test item";
		String imageUrl = "http://test.com/test.jpg";
		boolean completed = false;
		LocalDateTime dateAdded = LocalDateTime.now();
		ItemManipulationRequest request = new ItemManipulationRequest(name, imageUrl, false, dateAdded);
		assertEquals(name, request.getName());
		assertEquals(imageUrl, request.getImageUrl());
		assertFalse(request.isCompleted());
		assertEquals(dateAdded, request.getDateAdded());
	}

		@DisplayName("verifies that the ItemEntity class has the correct structure and behavior")
		@Test
		public void testItemEntity() {
		String name = "Test Item";
		String imageUrl = "https://test-image.com/test.jpg";
		LocalDateTime dateAdded = LocalDateTime.now();
		ItemEntity item = new ItemEntity(name, imageUrl, true, dateAdded);

		assertEquals(name, item.getName());
		assertEquals(imageUrl, item.getImageUrl());
		assertTrue(item.isCompleted());
		assertEquals(dateAdded, item.getDateAdded());

		String newName = "Updated Test Item";
		String newImageUrl = "https://test-image.com/updated.jpg";
		LocalDateTime newDateAdded = LocalDateTime.now();
		item.setName(newName);
		item.setImageUrl(newImageUrl);
		item.setCompleted(false);
		item.setDateAdded(newDateAdded);
		assertEquals(newName, item.getName());
		assertEquals(newImageUrl, item.getImageUrl());
		assertFalse(item.isCompleted());
		assertEquals(newDateAdded, item.getDateAdded());
	}

}


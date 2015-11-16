package com.ppship.spring_boot_helloworld.controller;



import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.linkWithRel;
import static org.springframework.restdocs.hypermedia.HypermediaDocumentation.links;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.*;
import static org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.*;
import static org.springframework.restdocs.payload.PayloadDocumentation.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.restdocs.operation.preprocess.Preprocessors.*;
import static org.springframework.restdocs.snippet.Attributes.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentation;
import org.springframework.restdocs.constraints.ConstraintDescriptions;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.restdocs.mockmvc.RestDocumentationResultHandler;
import org.springframework.restdocs.payload.FieldDescriptor;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ppship.spring_boot_helloworld.ExampleApplication;
import com.ppship.spring_boot_helloworld.param.CityParam;
import com.ppship.spring_boot_helloworld.param.PersonCreateParam;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ExampleApplication.class)
@WebAppConfiguration
public class PersonControllerDocumentation {
	@Rule
	public final RestDocumentation restDocumentation = new RestDocumentation(
			"target/generated-snippets");
	private RestDocumentationResultHandler document; 
	
	@Autowired
	public WebApplicationContext context;
	@Autowired
	private ObjectMapper objectMapper;
	
	private MockMvc mockMvc;

	@Before
	public void setUp() {
		this.document = document("{method-name}",
				preprocessRequest(prettyPrint()),
				preprocessResponse(prettyPrint()));
		
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.context)
				.apply(documentationConfiguration(this.restDocumentation))
				.alwaysDo(this.document)
				.build();
	}
	
	@Test
	public void personCreate() throws Exception{
		PersonCreateParam param = new PersonCreateParam();
		param.setName("testName");
		param.setDescription("testDesc");
		CityParam city = new CityParam();
		city.setId(123l);
		param.setCity(city);
		
		ConstrainedFields fields = new ConstrainedFields(PersonCreateParam.class);
		
		this.document.snippets(
				requestFields(
						fields.withPath("name").description("person name!")
						,fields.withPath("city").description("person.city!")
						,fields.withPath("city.id").description("person.city.id!")
						,fields.withPath("description").description("person descrition!").optional()
				)
				,responseFields(
						fields.withPath("name").description("person name!")
						,fields.withPath("city").description("person.city!")
						,fields.withPath("city.id").description("person.city.id!")
						,fields.withPath("description").description("person descrition!").optional()
				)
		);
		
		this.mockMvc.perform(
					post("/person/create", param)
					.contentType(MediaType.APPLICATION_JSON)
					.content(this.objectMapper.writeValueAsString(param))
				)
				.andExpect(status().isOk())
		;
	}
	
	@Test
	public void test1() {
		System.out.println("test!");
	}
	

	private static class ConstrainedFields {

		private final ConstraintDescriptions constraintDescriptions;

		ConstrainedFields(Class<?> input) {
			this.constraintDescriptions = new ConstraintDescriptions(input);
		}

		private FieldDescriptor withPath(String path) {
			return fieldWithPath(path).attributes(key("constraints").value(StringUtils
					.collectionToDelimitedString(this.constraintDescriptions
							.descriptionsForProperty(path), ". ")));
		}
	}
}

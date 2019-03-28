package com.todotask.helper;

import java.util.ArrayList;
import java.util.List;

import com.todotask.model.Author;

public class InsertAuthorHc {

	public List<Author> authorList;

	public InsertAuthorHc() {
		authorList= new ArrayList<Author>();
		authorList.add(new Author("George", "PHD", "CDAC", "george@company.com"));
		authorList.add(new Author("Tourci", "MSC", "DDAC", "tourci@company.com"));
		authorList.add(new Author("Likona", "BCA", "EDAC", "likona@company.com"));
		authorList.add(new Author("Ambani", "MCA", "FDAC", "ambani@company.com"));
		authorList.add(new Author("Mustch", "BAA", "GDAC", "mustch@company.com"));
	}

}

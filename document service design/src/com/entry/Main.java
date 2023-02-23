package com.entry;

import com.services.DocumnetManager;
import com.models.*;

public class Main {

	public static void main(String[] args) {
		DocumnetManager documentManager = new DocumnetManager();
		
		User u1 = new User("omkar");
		User u2 = new User("akash");
		User u3 = new User("suraj");
		
		documentManager.addDoc(u1, "doc_by_omkar");
		documentManager.addDoc(u2, "doc_by_akash");
		
		documentManager.addReadAccess(u1, u3, "doc_by_omkar");
		documentManager.addEditAccess(u2, u3, "doc_by_akash");
		documentManager.addReadAccess(u3, u1, "doc_by_omkar");
		documentManager.deleteDoc(u3, "doc_by_akash");
		documentManager.deleteDoc(u2, "doc_by_akash");
		documentManager.addContent(u1, "doc_by_omkar", "content by omkar");
		System.out.println(documentManager.readContent(u2, "doc_by_omkar"));
		System.out.println(documentManager.readContent(u3, "doc_by_omkar"));
		documentManager.addContent(u2, "doc_by_omkar", "abcd");
		documentManager.deleteDoc(u2, "doc_by_omkar");
	}

}

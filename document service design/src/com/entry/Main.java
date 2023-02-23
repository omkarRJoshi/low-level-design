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
		
		documentManager.addReadAccess(u1, u3, 0);
		documentManager.addEditAccess(u2, u3, 1);
		documentManager.addReadAccess(u3, u1, 0);
		documentManager.deleteDoc(u3, 1);
		documentManager.deleteDoc(u2, 1);
		documentManager.addContent(u1, 0, "content by omkar");
		System.out.println(documentManager.readContent(u2, 0));
		System.out.println(documentManager.readContent(u3, 0));
		documentManager.addContent(u2, 0, "abcd");
		documentManager.deleteDoc(u2, 0);
	}

}

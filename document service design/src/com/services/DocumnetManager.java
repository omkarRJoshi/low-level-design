package com.services;

import java.util.*;
import com.models.*;

public class DocumnetManager {
	Map<String, Document> docs;
	
	public DocumnetManager() {
		this.docs= new HashMap<String, Document>();
	}
	
	public void addDoc(User user, String documentName) {
		Document document = new Document(documentName, user);
		this.docs.put(document.getName(), document);
		System.out.println("document " + document.getName() + " is added by " + document.getOwner().getName() + " with id " + user.getId());
	}
	
	public void deleteDoc(User user, String doc_name) {
		Document document = getDocument(doc_name);
		if(isValidOwner(user, document)) {
			docs.remove(doc_name);
			System.out.println("removed doc " + document.getName() + " by " + user.getName());
			return;
		}
		System.out.println("cant delete doc as " + user.getName() + " is not valid owner of " + document.getName());
	}
	
	public void addReadAccess(User owner, User user, String doc_name) {
		Document document = getDocument(doc_name);
		if(!isValidOwner(owner, document)) {
			System.out.println("cant add read acccess to doc as " + owner.getName() + " is not valid owner of " + document.getName());
			return;
		}
		document.getReadAccess().add(user.getId());
		System.out.println("added read access for " + user.getName() + " by " + owner.getName());
	}
	
	public void addEditAccess(User owner, User user, String doc_name) {
		Document documnet = getDocument(doc_name);
		if(!isValidOwner(owner, documnet)) {
			System.out.println("cant add edit acccess to doc as " + owner.getName() + " is not valid owner of " + documnet.getName());
			return;
		}
		documnet.getReadAccess().add(user.getId());
		documnet.getEditAccess().add(user.getId());
		System.out.println("added edit access for " + user.getName() + " by " + owner.getName());
	}
	
	public void addContent(User user, String doc_name, String content) {
		Document document = getDocument(doc_name);
		if(!isValidAccessor(user.getId(), document.getEditAccess())) {
			System.out.println("user " + user.getName() + " is not valid editor for file " + document.getName());
			return;
		}
		else {
			System.out.println("user " + user.getName() + " added content for " + document.getName());
			document.setContent(content);
		}
	}
	
	public String readContent(User user, String doc_name) {
		Document document = getDocument(doc_name);
		if(!isValidAccessor(user.getId(), document.getReadAccess())) {
			System.out.println("user " + user.getName() + " is not valid reader for file " + document.getName());
			return null;
		}
		else {
			return document.getContent();
		}
	}
	
	private boolean isValidOwner(User user, Document documnet) {
		if(user.getId() != documnet.getOwner().getId()) {
			return false;
		}
		return true;
	}
	
	private Document getDocument(String doc_name) {
		return this.docs.get(doc_name);
	}
	
	private boolean isValidAccessor(int userId, Set<Integer> accessorSet) {
		if(!accessorSet.contains(userId)) {
			return false;
		}
		return true;
	}
}

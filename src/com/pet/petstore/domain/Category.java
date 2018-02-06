package com.pet.petstore.domain;

public class Category {
	
private int categoryId;
private String categoryName;
private String categoryDescription;
public int getCategoryId() {
	return categoryId;
}
public void setCategoryId(int categoryId) {
	this.categoryId = categoryId;
}
public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
public String getCategoryDescription() {
	return categoryDescription;
}
public void setCategoryDescription(String categoryDescription) {
	this.categoryDescription = categoryDescription;
}

public String toString() {
	StringBuilder builder = new StringBuilder();
	builder.append(categoryId);
	builder.append(categoryName);
	builder.append(categoryDescription);
	return builder.toString();
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime
			* result
			+ ((categoryDescription == null) ? 0 : categoryDescription
					.hashCode());
	result = prime * result + categoryId;
	result = prime * result
			+ ((categoryName == null) ? 0 : categoryName.hashCode());
	return result;
}
@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	final Category other = (Category) obj;
	if (categoryDescription == null) {
		if (other.categoryDescription != null)
			return false;
	} else if (!categoryDescription.equals(other.categoryDescription))
		return false;
	if (categoryId != other.categoryId)
		return false;
	if (categoryName == null) {
		if (other.categoryName != null)
			return false;
	} else if (!categoryName.equals(other.categoryName))
		return false;
	return true;
}

}

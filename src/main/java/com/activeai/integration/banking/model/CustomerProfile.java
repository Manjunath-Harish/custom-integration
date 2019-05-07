package com.activeai.integration.banking.model;

import com.activeai.integration.banking.constants.CustomerTitleEnum;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

/**
 * CustomerProfile
 */
@Validated
public class CustomerProfile {

  @JsonProperty("customerId")
  private String customerId = null;

  @JsonProperty("custSegment")
  private String custSegment = null;

  @JsonProperty("firstName")
  private String firstName = null;

  @JsonProperty("lastName")
  private String lastName = null;

  @JsonProperty("middleName")
  private String middleName = null;

  @JsonProperty("title")
  private CustomerTitleEnum title = null;

  @JsonProperty("address")
  private Address address = null;

  @JsonProperty("phone")
  @Valid
  private List<Phone> phone = null;

  @JsonProperty("email")
  @Valid
  private List<Email> email;

  public List<Email> getEmail() {
    return email;
  }

  public void setEmail(List<Email> email) {
    this.email = email;
  }

  /**
   * Customer ID example = "80975412"
   *
   * @return customerId
   **/
  public String getCustomerId() {
    return customerId;
  }

  public void setCustomerId(String customerId) {
    this.customerId = customerId;
  }

  /**
   * segment id / code of customer
   *
   * @return custSegment
   **/
  public String getCustSegment() {
    return custSegment;
  }

  public void setCustSegment(String custSegment) {
    this.custSegment = custSegment;
  }

  /**
   * First name of customer
   *
   * @return firstName
   **/
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Last name of customer
   *
   * @return lastName
   **/
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Middle name of customer
   *
   * @return middleName
   **/
  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  /**
   * Tile
   *
   * @return title
   **/
  public CustomerTitleEnum getTitle() {
    return title;
  }

  public void setTitle(CustomerTitleEnum title) {
    this.title = title;
  }

  public CustomerProfile address(Address address) {
    this.address = address;
    return this;
  }

  /**
   * Get address
   *
   * @return address
   **/
  @Valid public Address getAddress() {
    return address;
  }

  public void setAddress(Address address) {
    this.address = address;
  }

  /**
   * Get phone
   *
   * @return phone
   **/
  @Valid public List<Phone> getPhone() {
    return phone;
  }

  public void setPhone(List<Phone> phone) {
    this.phone = phone;
  }

  @Override public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    CustomerProfile customerProfile = (CustomerProfile) o;
    return Objects.equals(this.customerId, customerProfile.customerId) && Objects.equals(this.custSegment, customerProfile.custSegment) && Objects
        .equals(this.firstName, customerProfile.firstName) && Objects.equals(this.lastName, customerProfile.lastName) && Objects
        .equals(this.middleName, customerProfile.middleName) && Objects.equals(this.title, customerProfile.title) && Objects
        .equals(this.address, customerProfile.address) && Objects.equals(this.phone, customerProfile.phone);
  }

  @Override public int hashCode() {
    return Objects.hash(customerId, custSegment, firstName, lastName, middleName, title, address, phone);
  }

  @Override public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class CustomerProfile {\n");

    sb.append("    custId: ").append(toIndentedString(customerId)).append("\n");
    sb.append("    custSegment: ").append(toIndentedString(custSegment)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
    sb.append("    title: ").append(toIndentedString(title)).append("\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    phone: ").append(toIndentedString(phone)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}


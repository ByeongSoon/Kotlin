public class NullSafety {
  public static void main(String[] args){
    AddressTest address = new AddressTest();

    String postcode = null;
    if (address == null) {
      postcode = "No Postcode";
    } else {
      if (address.getPostcode()==null){
        postcode = "No Postcode";
      } else {
        postcode = address.getPostcode();
      }
    }
  }
}

class AddressTest{
  String postcode;

  public String getPostcode() {
    return postcode;
  }
}
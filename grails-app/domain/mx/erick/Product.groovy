package mx.erick

class Product {

  String name
  Double price
  String description
  Seller seller

    static constraints = {
      description nullable:true
    }
}

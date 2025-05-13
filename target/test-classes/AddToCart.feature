Feature: Sepete Ekleme Testi

Scenario: Bir ürünü sepete ekleme
  Given kullanıcı geçerli bilgilerle giriş yapar
  When kullanıcı 'sauce labs backpack' urunu sepete ekler
  And sepetim butonuna tıklanır,sepete gidilir
  Then 'sauce labs backpack' urununun sepete eklendiği kontrol edilir
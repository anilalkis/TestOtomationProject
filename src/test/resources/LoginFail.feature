Feature: Login Fail Testi

   Scenario: Geçersiz şifre ile login denemesi
    Given kullanıcı başarısız giriş denemesi için login sayfasında
    When kullanıcı "standard_user" ve hatalı "123456" şifresini girer
    Then kullanıcı hata mesajı görmelidir
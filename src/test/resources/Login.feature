Feature: Login Testi

  Scenario: Geçerli kullanıcı ile login
    Given kullanıcı login sayfasındadır
    When kullanıcı doğru kullanıcı adı ve şifreyi girer
    Then ana sayfaya yönlendirilmelidir

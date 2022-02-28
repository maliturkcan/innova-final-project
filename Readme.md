# Innova-Patika Bitirme Projesi

### Kullanılan Teknolojiler ;
Merhabalar, Innova Patika Spring Bootcamp bitirme ödevi olarak verilen ödevi hazırlamaya çalıştım. Projede kullanılan teknolojiler;

* [Spring Web](https://docs.spring.io/spring-boot/docs/2.6.3/reference/htmlsingle/#boot-features-developing-web-applications)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/2.6.3/reference/htmlsingle/#boot-features-jpa-and-spring-data)
* [Spring REST Services](https://spring.io/guides/tutorials/bookmarks/)
* [Spring Boot Maven Plugin](https://docs.spring.io/spring-boot/docs/2.6.3/maven-plugin/reference/html/)
* [Spring Validation](https://docs.spring.io/spring-framework/docs/3.2.x/spring-framework-reference/html/validation.html)
* [PostgreSQL](https://www.postgresql.org/docs/)
* [Modelmapper](http://modelmapper.org/user-manual/)
* [Lombok](https://projectlombok.org/features/all)
* [OpenAPI](https://swagger.io/docs/open-source-tools/swagger-editor/)

Swagger-UI arayüzüne erişmek için;
``` http://localhost:8080/swagger-ui/index.html ```

Proje Spring Framework kullanılarak hazırlanmıştır. Veritabanı olarak PostgreSQL kullanılmıştır. Proje ad, soyad, aylik gelir, tcno ve telefon no bilgileri girilerek kredi işlemlerimizi sorgulamamızı sağlıyor. Kullanıcı kayıt işlemi;

``` http://localhost:8080/customer/kaydet/ ```

adresi üzerinden gerçekleştirilebilmektedir.

``` http://localhost:8080/credit/sorgula/tcno/{tcNo} ```

Sorgulama işlemi tc kimlik no üzerinden yapılmaktadır. Son kısımda yer alan {tcNo} alanına kimlik numarası bilgilerini girerek kredi sonucunu sorgulayabilirsiniz.

Veritabanı işlemleri için PostgreSQL üzerinde ``` creditdb ``` adında bir veritabanı oluşturulması gerekmektedir. Ardından proje çalıştırıldığında tablolar otomatik olarak oluşmaktadır.

Proje görselleri;

![alt text](https://i.hizliresim.com/masy2c6.png)

Kredi sonucu sorgulama ekranı;
![alt text](https://i.hizliresim.com/j9y1j44.png)

Customer sorgu ekranı;
![alt text](https://i.hizliresim.com/d44m30g.png)

Customer kayıt ekranı;
![alt text](https://i.hizliresim.com/5dehvnq.png)

Veritabanı çıktısı;
![alt text](https://i.hizliresim.com/4x1igmp.png)

Son olarak, bize desteklerini esirgemeyen ve bilgilerinden istifade ettiğimiz hocamız Hamit Mızrak'a , bu eğitim programını düzenleyen Innova Bilişim'e ve Patika ekibine teşekkürü bir borç bilirim
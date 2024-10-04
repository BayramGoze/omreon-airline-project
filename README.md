# Havayolu Biletleme Sistemi - Backend Servisi

Bu proje, bir havayolu biletleme sistemi için geliştirilmiş backend servisidir. Servis, uçuş ve rota yönetimi, havayolu ve havaalanı yönetimi, bilet satın alma gibi işlemleri gerçekleştirmektedir. Proje, RESTful servisler üzerinden JSON formatında veri döner.

## Kullanılan Teknolojiler
- **Java 17**
- **Spring Boot**
- **Hibernate** (H2 Database ile)
- **Maven**
- **Postman** (İstek örnekleri ve test için)

## Kurulum ve Çalıştırma

1. **Projeyi Klonlayın**
    ```bash
    git clone https://github.com/BayramGoze/omreon-airline-project
    cd omreon-airline-project
    ```

2. **Bağımlılıkları Yükleyin**
    Maven kullanarak bağımlılıkları yükleyin:
    ```bash
    mvn clean install
    ```

3. **Uygulamayı Başlatın**
    Spring Boot uygulamasını aşağıdaki komut ile başlatın:
    ```bash
    mvn spring-boot:run
    ```
   Uygulama varsayılan olarak `http://localhost:8085` adresinde çalışacaktır.


## API Dokümantasyonu

# Havayolu İşlemleri

### Yeni Havayolu Ekle
- URL: `/airlines`
- Method: `POST`
- Request 
  ```
   {
    "name": "Türk Hava Yollari",
    "code": "THY"
  }
   ```  
Response:
  ```
{
    "id": 1,
    "name": "Türk Hava Yollari",
    "code": "THY"
}
```

### Havayolu Arama

- URL: `/airlines/{id}`
- Method: `GET`

- Response:
```
{
    "id": 1,
    "name": "Türk Hava Yollari",
    "code": "THY"
}
```
# Havaalanı İşlemleri

## Yeni Havaalanı Ekle

- URL: `/airports`
- Method: `POST`
- Request:
```

{
    "name":"Frankfurt Airport",
    "code":"FRA"
}
```
Response:

```

{
    "id": 1,
    "name": "Frankfurt Airport",
    "code": "FRA"
}

```

## Havaalanını Arama

- URL: `/airports/{id}`
- Method: `GET`

Response:
```

{
    "id": 1,
    "name": "Istanbul Airport",
    "city": "Istanbul",
}
```
# Rota İşlemleri

### Yeni Rota Ekle

- URL: `/routes`
- Method: `POST`
- Request:
```

{
    "sourceAirportId":1,
    "destinationAirportId":2,
    "distance":1000
}
```
Response:
```

{
    "id": 1,
    "sourceAirport": {
        "id": 1,
        "name": "Frankfurt Airport",
        "code": "FRA"
    },
    "destinationAirport": {
        "id": 2,
        "name": "Antalya Airport",
        "code": "AYT"
    },
    "distance": 1000.0
}
}
```
### Rota Arama

- URL: `/routes/{id}`
- Method: `GET`
- Response:
```

 {
        "id": 1,
        "sourceAirport": {
            "id": 1,
            "name": "Frankfurt Airport",
            "code": "FRA"
        },
        "destinationAirport": {
            "id": 2,
            "name": "Antalya Airport",
            "code": "AYT"
        },
        "distance": 1000.0
    }

```

# Havayolu Uçuş Ekleme İşlemi
- URL: `/addFlightToAirline`
- Method: `POST`
- Request:
```

{
    "flightNumber":"XC101",
    "departure":"AYT",
    "arrival":"FRA",
    "price":5000,
    "capacity":300,
    "soldTickets":300
}
```

## Havayolu Uçuş Arama
- URL: `/flights/getFlightsByAirline/{airline_id}`
- Method: `GET`
- Response:
```
{
    "id": 1,
    "flightNumber": "XC101",
    "departure": "AYT",
    "arrival": "FRA",
    "price": 5000.0,
    "capacity": 300,
    "soldTickets": 300,
    "airline": {
        "id": 1,
        "name": "Turk Hava Yollari",
        "code": "THY"
    }
}

```

# Bilet Satın Alma İşlemi

### Yeni Bilet Satın Alma

- URL: `/tickets`
- Method: `POST`
- Request:

```

{
    "flightId":1,
    "passengerName":"Bayram Goze",
    "creditCardNumber":"5101526622112212"
}

```
Response:

```

{
    "id": 1,
    "flight": {
        "id": 1,
        "flightNumber": "XC101",
        "departure": "AYT",
        "arrival": "FRA",
        "price": 5000.0,
        "capacity": 300,
        "soldTickets": 301,
        "airline": {
            "id": 1,
            "name": "Turk Hava Yollari",
            "code": "THY"
        }
    },
    "passengerName": "Bayram Goze",
    "creditCardNumber": "************2212",
    "pnrNumber": "5KG178",
    "status": 1
}
```

# Bilet İptal Etme

- URL: `/tickets/cancelTicket/{pnr_number}`
- Method: `PUT`
  
- Response:  200 OK


# Pnr Numarasına Ait Uçuşu Getirme

  - URL: `/tickets/getTicketByPnrNumber/{pnr_number}`
  - Method: `GET`  
  - Response:
     ```
     {
    "id": 5,
    "flight": {
        "id": 1,
        "flightNumber": "XC101",
        "departure": "AYT",
        "arrival": "FRA",
        "price": 5000.0,
        "capacity": 300,
        "soldTickets": 305,
        "airline": {
            "id": 1,
            "name": "Sun Express",
            "code": "SUN"
        }
    },
    "passengerName": "Bayram Goze",
    "creditCardNumber": "************2212",
    "pnrNumber": "A9UFG8",
    "status": 1
    }
     ```
    


## Postman Koleksiyonu

Tüm uç noktaları içeren Postman koleksiyonuna buradaki dizinden erişebilir veya aşağıdaki adımlarla dosyayı yükleyebilirsiniz:
Postman açıldıktan sonra "Import" seçeneğine tıklayın.
İndirilen Omreon.postman_collection.json dosyasını yükleyin.



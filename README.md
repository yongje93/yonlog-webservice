# 검색 시스템
> 검색엔진을 활용한 검색 시스템

## 폴더정보
```
.
├── src
│    └── main
│      ├── java
│      │   └── com.yonlog.coding        << 소스 파일 >>
│      └── resources
│           ├── static                  << css, js 등  >>
│           ├── templates               << thymeleaf 관련 >>
│           └── application.yml         << 환경설정 >>
│           
├── gradle                              << Gradle >>
│    └── wrapper
│        ├── gradle-wrapper.jar         << Wrapper 파일 >>
│        └── gradle-wrapper.properties  << Wrapper 설정 >>
├── gradlew                             << 유닉스용 wrapper 실행 스크립트 >>
├── gradlew.bat                         << 윈도우용 wrapper 실행 스크립트 >>
├── build.gradle                        << Gradle 빌드 스크립트 >>
└── README.md                           << 프로젝트 설명 >>
```

## 실행 방법
* 외장 톰캣 이용시: Tomcat에 프로젝트 추가 후, Tomcat start
  > application.yml에서 active 입력  
  spring.profiles.active: {local,dev,prod 중 선택}

* 내장 톰캣 이용시: com.yonlog.coding.CodingApplication 실행
  > application.yml에서 active 입력  
  spring.profiles.active: {local,dev,prod 중 선택}

* Swagger URL : <http://127.0.0.1:8080/swagger-ui.html>

## 환경설정
1. application.yml
* Spring 및 SpringDoc 관련 설정  
* DB 정보 및 JPA 설정
# 나랑 같이 먹을래...? (GetEatWithMe) -BackEnd

### 제작 이유
나랑 같이 먹을래...? 어플은 안드로이드 기반 어플리케이션입니다.<br>
혼자 밥을 먹기 두려워 하는 사람들을 위해 같이 밥을 먹을 사람을 찾아주는 어플입니다.<br>
같이 밥을 먹기 위한 게시물을 올리면 신청을 통해 채팅으로 연결해주는 프로그램입니다.<br>
해당 Repository는 Backend 코드를 포함하고 있습니다. <br>

### 기술 스택
- Spring Framework
- MariaDB
- AWS EC2
- Apache Tomcat
- Ubuntu
- MyBatis

### 개발 환경
개발 환경
   - Intellij 를 이용하여서 Spring Boot 로 개발했습니다.
   - REST API 방식으로 통신하도록 만들었습니다.
   - 관계형 DB인 MariaDB 를 이용
   - 자바 17 버전 사용
   - FireBase Cloud Messaging Service 를 이용한 Push Message 구현을 위해 firebase-admin 6.7.0 dependency 사용
   - Getter Setter 를 용이하게 사용하기 위해 lombok 사용
   - 안드로이드와 Retrofit 을 이용한 통신을 하기 위해서 Retrofit dependency 사용
   - mariaDB 연결을 위한 mariadb.jdbc, mybatis dependency 사용

2. 배포 환경
   - AWS EC2(+탄력적 ip)사용
   - PUTTY 를 사용하여서 java 와 mariadb 설치
   - 프로젝트에서 jar 파일을 FileZilla 이용해서 배포 후 실행
   - 배포시 ubuntu 를 통해 접속해야 하며
     ```nohup java -jar "jar 파일 이름".jar&```
     로  실행해야 터미널을 종료해도 실행된다.
### 프로젝트 구성도
![asdf](https://user-images.githubusercontent.com/68294499/172062071-d9a1804c-3ec1-480a-bd0e-e16e7fb43c72.png)

- **Client-Spring** : MariaDB에 있는 정보들이 필요할 때, Firebase 를 통한 FCM을 보내고 싶을 때 통신합니다.
- **Spring-Firebase** : Spring 에 Push Message 를 보내라는 정보가 들어오면, Spring 은 가지고 있는 정보들을 Firebase 에 전송합니다. (일방적 통신)
- **Client-Firebase** : Client 가 단체 채팅방을 사용할때에는 Firebase 의 Realtime Database 를 사용합니다. <br> Firebase 에서 Push Message 를 보낼 때는 Firebase 가 Client 의 token_id 로 Push Message 를 보냅니다.
### 프로젝트 ERD

![image](https://user-images.githubusercontent.com/68294499/170973695-cc195329-b08f-4a57-b788-3f493184ee5f.png)

## 프로젝트 설치 방법
   - resources/application.properties 에서 해당하는 부분을 수정해야합니다.
     ```
     spring.datasource.driverClassName=org.mariadb.jdbc.Driver
     spring.datasource.url=jdbc:mariadb://"DB IP":"DB port"/"DB 이름"?autoReconnect=true
     spring.datasource.username="DB user 이름"
     spring.datasource.password="DB 암호"
     spring.jpa.show-sql=true
     spring.jpa.hibernate.ddl-auto=update
     spring.jpa.properties.hibernate.format_sql=true
      ```
   - 프로젝트 상단에 있는 db파일의 테이블 정보를 데이터베이스에 추가해야합니다.
   - 각 데이터베이스의 INSERT 코드는 다음과 같습니다
   - useralarm
   ```
   CREATE TABLE `useralarm` (
	`id` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	`request` INT(11) NULL DEFAULT NULL,
	`opposite_id` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	`post_id` INT(11) NULL DEFAULT NULL,
	`view` INT(11) NULL DEFAULT NULL,
	`nickname` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	`opposite_nickname` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	`alarm_id` INT(11) NOT NULL,
	`id_token_id` VARCHAR(1000) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	`opposite_token_id` VARCHAR(1000) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	`restaurant` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	`date` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	`mod_date` DATETIME NOT NULL DEFAULT current_timestamp(),
	PRIMARY KEY (`alarm_id`) USING BTREE,
	INDEX `id` (`id`) USING BTREE,
	CONSTRAINT `useralarm_ibfk_1` FOREIGN KEY (`id`) REFERENCES `geteatwithme`.`userprofile` (`id`) ON UPDATE RESTRICT ON DELETE RESTRICT
)
COLLATE='utf8mb3_general_ci'
ENGINE=InnoDB
;
   ```
   -userprofile
   ```
   CREATE TABLE `userprofile` (
	`id` VARCHAR(100) NOT NULL COLLATE 'utf8mb3_general_ci',
	`name` VARCHAR(100) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	`gender` INT(11) NULL DEFAULT NULL,
	`password` VARCHAR(200) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	`age` INT(11) NULL DEFAULT NULL,
	`nickname` VARCHAR(200) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	`grade` DOUBLE NULL DEFAULT NULL,
	`token_id` VARCHAR(1000) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb3_general_ci'
ENGINE=InnoDB
;
   ```
 -post
 ```
 CREATE TABLE `post` (
	`id` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	`restaurant` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	`meeting_place` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	`category` INT(11) NULL DEFAULT NULL,
	`max_people` INT(11) NULL DEFAULT NULL,
	`cur_people` INT(11) NULL DEFAULT NULL,
	`meeting_date` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	`meeting_time` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb3_general_ci',
	`contents` VARCHAR(50) NOT NULL COLLATE 'utf8mb3_general_ci',
	`Longitude` DOUBLE NULL DEFAULT '0',
	`Latitude` DOUBLE NOT NULL DEFAULT '0',
	`post_id` INT(11) NOT NULL,
	`meet_x` DOUBLE NULL DEFAULT NULL,
	`meet_y` DOUBLE NULL DEFAULT NULL,
	`restaurant_id` INT(11) NULL DEFAULT NULL,
	`visible` INT(11) NULL DEFAULT NULL,
	`post_visible` INT(11) NULL DEFAULT NULL,
	`sec` INT(11) NULL DEFAULT NULL,
	PRIMARY KEY (`post_id`) USING BTREE
)
COLLATE='utf8mb3_general_ci'
ENGINE=InnoDB
;
 ```
 -event post
 ```
 CREATE DEFINER=`root`@`localhost` EVENT `POST`
	ON SCHEDULE
		EVERY 1 MINUTE STARTS '2022-05-29'
	ON COMPLETION NOT PRESERVE
	ENABLE
	COMMENT ''
	DO UPDATE post SET post_visible = IF(CONCAT(REPLACE(post.meeting_date,"/","-")," ",SEC_TO_TIME(post.sec))>NOW(), IF(cur_people=max_people, 0, IF(post_visible=0,0,1)), 0 )
 ```
## 프로젝트 사용법, 기능
   1. 프로젝트를 설치 합니다.
   2. 호스팅 한 서버에 프로젝트 파일을 배포합니다.
   3. UserController
      - **역할** : REST API 통신을 위한 Controller 들이 모여있습니다.
      - **관련 Object** : model Package(Alarm,Post,UserProfile)
   4. UserMapper
      - **역할** : MariaDB에서 SQL 문을 실행하기 위한 SQL 문들이 들어있습니다.
   5. Firebase
      - **역할** : Firebase Cloud Messaging 을 하기 위해서 필요한 정보들이 있습니다.
   6. Model
      - **역할** : JSON 객체로 바꾸기 위한 클래스들이 모여 있는 곳입니다.

## 버그
  -5월 30일(배포일 기준) 에서는 현재 버그는 없습니다.

## 프로젝트 작성자 및 도움을 준 사람
#### 작성자
- 오창묵 [Github](https://github.com/Godmook)
  <br>이메일 cmoh4135@naver.com
#### 도움을 준 사람
- 김예진 [Github](https://github.com/originalchaltteokcookie)
  <br>이메일 wndrnrdk@naver.com
- 정현진 [Github](https://github.com/Hyunjin-Jung)
  <br>이메일 hjjung0810@gmail.com

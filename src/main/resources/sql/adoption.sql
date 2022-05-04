

---------------------------------------------------------------------------------------------------
--假資料
----------------
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--建立會員&寵物假資料--
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values (mem_seq.NEXTVAL, '黃琦琦',  to_date('1994-1-17', 'yyyy-mm-dd'),  0,  '09-12345678',  'lizahung1008@gmail.com',  '台北市信義區市府路100號101樓', 'king', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', 'king', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values (mem_seq.NEXTVAL, '方芳芳',  to_date('1994-05-01', 'yyyy-mm-dd'),  0,  '09-21957846',  'lizahung1008@gmail.com',  '桃園市中壢區中央路300號', 'blake', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', 'blake', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values (mem_seq.NEXTVAL, '王大靖',  to_date('1994-01-09', 'yyyy-mm-dd'),  1,  '09-87652154',  'lizahung1008@gmail.com',  '台中市慶濟路200號', 'clark', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', 'clark', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values (mem_seq.NEXTVAL, '林郁',  to_date('1994-04-02', 'yyyy-mm-dd'),  0,  '09-64913584',  'lizahung1008@gmail.com',  '台南市找不到路100號', 'jones', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', 'jones', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values (mem_seq.NEXTVAL, '陳群杰',  to_date('1994-09-28', 'yyyy-mm-dd'),  1,  '09-35846291',  'lizahung1008@gmail.com',  '高雄市某條路10號', 'martin', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', 'martin', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values (mem_seq.NEXTVAL, '張元元',  to_date('1994-02-02', 'yyyy-mm-dd'),  1,  '09-34681752',  'lizahung1008@gmail.com',  '新北市巴巴路50號', 'allen', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', 'allen', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values (mem_seq.NEXTVAL, '林小晴',  to_date('1994-09-28', 'yyyy-mm-dd'),  0,  '09-82619473',  'lizahung1008@gmail.com',  '新竹縣後田路30號', 'turner', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', 'turner', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values (mem_seq.NEXTVAL, '吳開司',  to_date('1994-12-03', 'yyyy-mm-dd'),  1,  '09-37486255',  'lizahung1008@gmail.com',  '苗栗國梅投路40號', 'james', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW','james', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values (mem_seq.NEXTVAL, '潘又真',  to_date('1994-02-22', 'yyyy-mm-dd'),  0,  '09-11886492',  'lizahung1008@gmail.com',  '彰化縣藍藍路20號', 'ward', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW','ward', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values (mem_seq.NEXTVAL, '吳彼得',  to_date('1994-12-03', 'yyyy-mm-dd'),  1,  '09-76559482',  'lizahung1008@gmail.com',  '雲林縣阿喜鐵路52巷13號14樓', 'ford', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW','ford', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values (mem_seq.NEXTVAL, '吳大衛',  to_date('1993-12-17', 'yyyy-mm-dd'),  1,  '09-11269574',  'lizahung1008@gmail.com',  '嘉義市蘇巴路800號', 'smith', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW','smith', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values (mem_seq.NEXTVAL, '郭司福',  to_date('1994-12-09', 'yyyy-mm-dd'),  1,  '09-12594763',  'lizahung1008@gmail.com',  '宜蘭縣密之肝路99號', 'scott', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', 'scott', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values (mem_seq.NEXTVAL, '黃彬彬',  to_date('1983-01-12', 'yyyy-mm-dd'),  1,  '09-44685975',  'lizahung1008@gmail.com',  '花蓮縣爬坡路88號', 'adams', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW','adams', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values (mem_seq.NEXTVAL, '董咚咚',  to_date('1995-01-23', 'yyyy-mm-dd'),  0,  '09-15226345',  'lizahung1008@gmail.com',  '台東縣下坡路120號', 'miller', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW','miller', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values (mem_seq.NEXTVAL, '陳莉莉',  to_date('1996-06-24', 'yyyy-mm-dd'),  0,  '09-33486597',  'lizahung1008@gmail.com',  '台北市內湖區仁愛路38號', 'alice', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW','alice', null);
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--建立後台假資料--
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--新增資料(後台管理員)
INSERT INTO EMPLOYEE (EMP_NO, EMP_NAME, EMP_ACCOUNT, EMP_PSW, EMP_NICKNAME, EMP_ACC_STATUS, EMP_EMAIL, EMP_PHOTO, EMP_ROLE, EMP_ARR_DATE) VALUES (EMPLOYEE_SEQ.NEXTVAL, '小元子', 'EA10350', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', '大元子', 0, 'lizahung1008@gmail.com', NULL,'ROLE_ADMIN',TO_DATE('2019-08-08','YYYY-MM-DD'));
INSERT INTO EMPLOYEE (EMP_NO, EMP_NAME, EMP_ACCOUNT, EMP_PSW, EMP_NICKNAME, EMP_ACC_STATUS, EMP_EMAIL, EMP_PHOTO, EMP_ROLE, EMP_ARR_DATE) VALUES (EMPLOYEE_SEQ.NEXTVAL, '小群子', 'EA10311', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', '大群子', 0, 'lizahung1008@gmail.com', NULL,'ROLE_STAFF',TO_DATE('2019-08-08','YYYY-MM-DD'));
INSERT INTO EMPLOYEE (EMP_NO, EMP_NAME, EMP_ACCOUNT, EMP_PSW, EMP_NICKNAME, EMP_ACC_STATUS, EMP_EMAIL, EMP_PHOTO, EMP_ROLE, EMP_ARR_DATE) VALUES (EMPLOYEE_SEQ.NEXTVAL, '小凱', 'EA10349', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', '大凱', 0, 'lizahung1008@gmail.com', NULL,'ROLE_STAFF',TO_DATE('2019-08-08','YYYY-MM-DD'));
INSERT INTO EMPLOYEE (EMP_NO, EMP_NAME, EMP_ACCOUNT, EMP_PSW, EMP_NICKNAME, EMP_ACC_STATUS, EMP_EMAIL, EMP_PHOTO, EMP_ROLE, EMP_ARR_DATE) VALUES (EMPLOYEE_SEQ.NEXTVAL, '小旭子', 'EA10354', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', '大旭子', 0, 'lizahung1008@gmail.com', NULL,'ROLE_STAFF',TO_DATE('2019-08-08','YYYY-MM-DD'));
INSERT INTO EMPLOYEE (EMP_NO, EMP_NAME, EMP_ACCOUNT, EMP_PSW, EMP_NICKNAME, EMP_ACC_STATUS, EMP_EMAIL, EMP_PHOTO, EMP_ROLE, EMP_ARR_DATE) VALUES (EMPLOYEE_SEQ.NEXTVAL, '小晴子', 'EA10310', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', '大晴子', 0, 'lizahung1008@gmail.com', NULL,'ROLE_STAFF',TO_DATE('2019-08-08','YYYY-MM-DD'));
INSERT INTO EMPLOYEE (EMP_NO, EMP_NAME, EMP_ACCOUNT, EMP_PSW, EMP_NICKNAME, EMP_ACC_STATUS, EMP_EMAIL, EMP_PHOTO, EMP_ROLE, EMP_ARR_DATE) VALUES (EMPLOYEE_SEQ.NEXTVAL, '小郁子', 'EA10326', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', '大郁子', 0, 'lizahung1008@gmail.com', NULL,'ROLE_ADMIN',TO_DATE('2019-08-08','YYYY-MM-DD'));
INSERT INTO EMPLOYEE (EMP_NO, EMP_NAME, EMP_ACCOUNT, EMP_PSW, EMP_NICKNAME, EMP_ACC_STATUS, EMP_EMAIL, EMP_PHOTO, EMP_ROLE, EMP_ARR_DATE) VALUES (EMPLOYEE_SEQ.NEXTVAL, '公主', 'EA10341', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', '領班', 0, 'lizahung1008@gmail.com', NULL,'ROLE_STAFF',TO_DATE('2019-08-08','YYYY-MM-DD'));
INSERT INTO EMPLOYEE (EMP_NO, EMP_NAME, EMP_ACCOUNT, EMP_PSW, EMP_NICKNAME, EMP_ACC_STATUS, EMP_EMAIL, EMP_PHOTO, EMP_ROLE, EMP_ARR_DATE) VALUES (EMPLOYEE_SEQ.NEXTVAL, '頭目', 'EA10321', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', '大師兄', 0, 'lizahung1008@gmail.com', NULL,'ROLE_STAFF',TO_DATE('2019-08-08','YYYY-MM-DD'));

--新增資料(後台功能)

INSERT INTO BACKFUNCTION (FUN_NO, FUN_NAME, FUN_URL) VALUES (BACKFUNCTION_SEQ.NEXTVAL, '員工管理','/employee/management');
INSERT INTO BACKFUNCTION (FUN_NO, FUN_NAME, FUN_URL) VALUES (BACKFUNCTION_SEQ.NEXTVAL, '員工權限管理','/employee-auth/management');
INSERT INTO BACKFUNCTION (FUN_NO, FUN_NAME, FUN_URL) VALUES (BACKFUNCTION_SEQ.NEXTVAL, '領養管理','/adoption/management');
INSERT INTO BACKFUNCTION (FUN_NO, FUN_NAME, FUN_URL) VALUES (BACKFUNCTION_SEQ.NEXTVAL, '寵物管理','/adopet/management');
INSERT INTO BACKFUNCTION (FUN_NO, FUN_NAME, FUN_URL) VALUES (BACKFUNCTION_SEQ.NEXTVAL, '會員權限設定','/member-auth/management');

--新增資料(管理員權限)
INSERT INTO EMP_AUTHORITY (EMP_NO, FUN_NO) VALUES ('1', '3');
INSERT INTO EMP_AUTHORITY (EMP_NO, FUN_NO) VALUES ('1', '2');
INSERT INTO EMP_AUTHORITY (EMP_NO, FUN_NO) VALUES ('6', '2');
INSERT INTO EMP_AUTHORITY (EMP_NO, FUN_NO) VALUES ('6', '1');
INSERT INTO EMP_AUTHORITY (EMP_NO, FUN_NO) VALUES ('6', '3');
INSERT INTO EMP_AUTHORITY (EMP_NO, FUN_NO) VALUES ('6', '4');
INSERT INTO EMP_AUTHORITY (EMP_NO, FUN_NO) VALUES ('6', '5');
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--建立領養假資料--
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
INSERT INTO ADO_PET (ADO_PET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PET_WEIGHT,PET_CAT,PET_CHAR,LOCATION)
VALUES(ADOPET_SEQ.NEXTVAL,'0','0','老三','米克斯','1',TO_DATE('2019-08-08','YYYY-MM-DD'),'6','3','有雙立耳、圓滾滾的眼睛','0');
INSERT INTO ADO_PET (ADO_PET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PET_WEIGHT,PET_CAT,LOCATION)
VALUES(ADOPET_SEQ.NEXTVAL,'0','0','妞妞','米克斯','1',TO_DATE('2019-09-16','YYYY-MM-DD'),'4.5','2','1');
INSERT INTO ADO_PET (ADO_PET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PET_WEIGHT,PET_CAT,LOCATION)
VALUES(ADOPET_SEQ.NEXTVAL,'0','0','蜜奇','貴賓','0',TO_DATE('2013-09-16','YYYY-MM-DD'),'5.5','3','2');
INSERT INTO ADO_PET (ADO_PET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PET_WEIGHT,PET_CAT,LOCATION)
VALUES(ADOPET_SEQ.NEXTVAL,'0','0','小黑','拉布拉多','0',TO_DATE('2010-09-16','YYYY-MM-DD'),'16','4','2');
INSERT INTO ADO_PET (ADO_PET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PET_WEIGHT,PET_CAT,PET_CHAR,LOCATION)
VALUES(ADOPET_SEQ.NEXTVAL,'0','0','Green','狐狸犬','0',TO_DATE('2018-03-06','YYYY-MM-DD'),'10','3','柔亮蓬鬆的白毛、充滿微笑的Green，十分俊帥','0');
INSERT INTO ADO_PET (ADO_PET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PET_WEIGHT,PET_CAT,PET_CHAR,LOCATION)
VALUES(ADOPET_SEQ.NEXTVAL,'0','0','Yummy','米格魯','1',TO_DATE('2019-09-17','YYYY-MM-DD'),'13','4','窈窕身材和修長的四肢','0');
INSERT INTO ADO_PET (ADO_PET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PET_WEIGHT,PET_CAT,LOCATION)
VALUES(ADOPET_SEQ.NEXTVAL,'0','0','巧巧','米克斯','0',TO_DATE('2019-08-31','YYYY-MM-DD'),'12','4','2');
INSERT INTO ADO_PET (ADO_PET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PET_WEIGHT,PET_CAT,LOCATION)
VALUES(ADOPET_SEQ.NEXTVAL,'0','0','Qbo','拉布拉多','0',TO_DATE('2019-07-31','YYYY-MM-DD'),'20','5','1');
INSERT INTO ADO_PET (ADO_PET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PET_WEIGHT,PET_CAT,LOCATION)
VALUES(ADOPET_SEQ.NEXTVAL,'0','0','錢寶','比利時狼犬','0',TO_DATE('2017-07-31','YYYY-MM-DD'),'20','5','1');
INSERT INTO ADO_PET (ADO_PET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PET_WEIGHT,PET_CAT,LOCATION)
VALUES(ADOPET_SEQ.NEXTVAL,'0','0','比特媽媽','比特犬','0',TO_DATE('2018-12-31','YYYY-MM-DD'),'10','4','2');
INSERT INTO ADO_PET (ADO_PET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PET_WEIGHT,PET_CAT,LOCATION)
VALUES(ADOPET_SEQ.NEXTVAL,'0','1','傑克','混種貓','0',TO_DATE('2016-12-31','YYYY-MM-DD'),'7','0','0');
INSERT INTO ADO_PET (ADO_PET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PET_WEIGHT,PET_CAT,LOCATION)
VALUES(ADOPET_SEQ.NEXTVAL,'0','1','黑魯魯','混種貓','0',TO_DATE('2015-12-31','YYYY-MM-DD'),'7.5','0','0');
INSERT INTO ADO_PET (ADO_PET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PET_WEIGHT,PET_CAT,PET_CHAR,LOCATION)
VALUES(ADOPET_SEQ.NEXTVAL,'0','1','小朋友','混種貓','1',TO_DATE('2020-09-17','YYYY-MM-DD'),'7.5','0','毛色為虎斑的橘貓','0');
INSERT INTO ADO_PET (ADO_PET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PET_WEIGHT,PET_CAT,LOCATION)
VALUES(ADOPET_SEQ.NEXTVAL,'0','0','饅頭','法鬥','0',TO_DATE('2019-07-03','YYYY-MM-DD'),'7','3','2');
INSERT INTO ADO_PET (ADO_PET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PET_WEIGHT,PET_CAT,PET_CHAR,LOCATION)
VALUES(ADOPET_SEQ.NEXTVAL,'0','1','娜娜','混種貓','1',TO_DATE('2020-10-30','YYYY-MM-DD'),'5','0','毛色為黑白乳牛的貓','2');


INSERT INTO ADO_PET_FOLLOW(MEM_NO, ADO_PET_NO)
VALUES ('7','14');
INSERT INTO ADO_PET_FOLLOW(MEM_NO, ADO_PET_NO)
VALUES ('1','11');
INSERT INTO ADO_PET_FOLLOW(MEM_NO, ADO_PET_NO)
VALUES ('4','1');



INSERT INTO ADO_RESERVATION(RESERVATIONNO,ADO_PET_NO,MEM_NO,VISIT_DATE,RESERVATION_STATUS)
VALUES (ADORESERVATION_SEQ.NEXTVAL,'15','15',TO_DATE('2020-9-30','YYYY-MM-DD'),'0');
INSERT INTO ADO_RESERVATION(RESERVATIONNO,ADO_PET_NO,MEM_NO,VISIT_DATE,RESERVATION_STATUS)
VALUES (ADORESERVATION_SEQ.NEXTVAL,'1','4',TO_DATE('2020-11-15','YYYY-MM-DD'),'0');
INSERT INTO ADO_RESERVATION(RESERVATIONNO,ADO_PET_NO,MEM_NO,VISIT_DATE,RESERVATION_STATUS)
VALUES (ADORESERVATION_SEQ.NEXTVAL,'14','7',TO_DATE('2020-11-13','YYYY-MM-DD'),'0');
INSERT INTO ADO_RESERVATION(RESERVATIONNO,ADO_PET_NO,MEM_NO,VISIT_DATE,RESERVATION_STATUS)
VALUES (ADORESERVATION_SEQ.NEXTVAL,'2','1',TO_DATE('2020-11-14','YYYY-MM-DD'),'0');
INSERT INTO ADO_RESERVATION(RESERVATIONNO,ADO_PET_NO,MEM_NO,VISIT_DATE,RESERVATION_STATUS)
VALUES (ADORESERVATION_SEQ.NEXTVAL,'3','12',TO_DATE('2020-11-20','YYYY-MM-DD'),'0');


INSERT INTO Ado_Pet_Pic(ADO_PIC_NO,ADO_PET_NO,ADO_PET_PIC)
VALUES (AdoPetPic_SEQ.NEXTVAL,'1',null);
INSERT INTO Ado_Pet_Pic(ADO_PIC_NO,ADO_PET_NO,ADO_PET_PIC)
VALUES (AdoPetPic_SEQ.NEXTVAL,'2',null);
INSERT INTO Ado_Pet_Pic(ADO_PIC_NO,ADO_PET_NO,ADO_PET_PIC)
VALUES (AdoPetPic_SEQ.NEXTVAL,'3',null);


commit;
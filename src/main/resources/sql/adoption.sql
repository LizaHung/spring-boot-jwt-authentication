

---------------------------------------------------------------------------------------------------
--假資料
----------------
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--建立會員&寵物假資料--
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------


INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values ('M' || lpad(mem_seq.NEXTVAL, 3, '0'), '黃琦琦',  to_date('1994-1-17', 'yyyy-mm-dd'),  0,  '09-12345678',  'aaa@xxx.com',  '台北市信義區市府路100號101樓', 'king', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', 'king', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values ('M' || lpad(mem_seq.NEXTVAL, 3, '0'), '方芳芳',  to_date('1994-05-01', 'yyyy-mm-dd'),  0,  '09-21957846',  'bbb@xxx.com',  '桃園市中壢區中央路300號', 'blake', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', 'blake', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values ('M' || lpad(mem_seq.NEXTVAL, 3, '0'), '王大靖',  to_date('1994-01-09', 'yyyy-mm-dd'),  1,  '09-87652154',  'ccc@xxx.com',  '台中市慶濟路200號', 'clark', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', 'clark', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values ('M' || lpad(mem_seq.NEXTVAL, 3, '0'), '林郁',  to_date('1994-04-02', 'yyyy-mm-dd'),  0,  '09-64913584',  'ddd@xxx.com',  '台南市找不到路100號', 'jones', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', 'jones', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values ('M' || lpad(mem_seq.NEXTVAL, 3, '0'), '陳群杰',  to_date('1994-09-28', 'yyyy-mm-dd'),  1,  '09-35846291',  'eee@xxx.com',  '高雄市某條路10號', 'martin', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', 'martin', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values ('M' || lpad(mem_seq.NEXTVAL, 3, '0'), '張元元',  to_date('1994-02-02', 'yyyy-mm-dd'),  1,  '09-34681752',  'fff@xxx.com',  '新北市巴巴路50號', 'allen', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', 'allen', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values ('M' || lpad(mem_seq.NEXTVAL, 3, '0'), '林小晴',  to_date('1994-09-28', 'yyyy-mm-dd'),  0,  '09-82619473',  'ggg@xxx.com',  '新竹縣後田路30號', 'turner', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', 'turner', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values ('M' || lpad(mem_seq.NEXTVAL, 3, '0'), '吳開司',  to_date('1994-12-03', 'yyyy-mm-dd'),  1,  '09-37486255',  'hhh@xxx.com',  '苗栗國梅投路40號', 'james', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW','james', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values ('M' || lpad(mem_seq.NEXTVAL, 3, '0'), '潘又真',  to_date('1994-02-22', 'yyyy-mm-dd'),  0,  '09-11886492',  'iii@xxx.com',  '彰化縣藍藍路20號', 'ward', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW','ward', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values ('M' || lpad(mem_seq.NEXTVAL, 3, '0'), '吳彼得',  to_date('1994-12-03', 'yyyy-mm-dd'),  1,  '09-76559482',  'jjj@xxx.com',  '雲林縣阿喜鐵路52巷13號14樓', 'ford', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW','ford', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values ('M' || lpad(mem_seq.NEXTVAL, 3, '0'), '吳大衛',  to_date('1993-12-17', 'yyyy-mm-dd'),  1,  '09-11269574',  'kkk@xxx.com',  '嘉義市蘇巴路800號', 'smith', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW','smith', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values ('M' || lpad(mem_seq.NEXTVAL, 3, '0'), '郭司福',  to_date('1994-12-09', 'yyyy-mm-dd'),  1,  '09-12594763',  'lll@xxx.com',  '宜蘭縣密之肝路99號', 'scott', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', 'scott', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values ('M' || lpad(mem_seq.NEXTVAL, 3, '0'), '黃彬彬',  to_date('1983-01-12', 'yyyy-mm-dd'),  1,  '09-44685975',  'mmm@xxx.com',  '花蓮縣爬坡路88號', 'adams', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW','adams', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values ('M' || lpad(mem_seq.NEXTVAL, 3, '0'), '董咚咚',  to_date('1995-01-23', 'yyyy-mm-dd'),  0,  '09-15226345',  'ppp@xxx.com',  '台東縣下坡路120號', 'miller', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW','miller', null);
INSERT INTO MEMBER (mem_No, mem_Name, mem_Birth, mem_Sex, mem_Phone, mem_Email, mem_Address, mem_Id, mem_Psw, mem_Nickname, mem_Photo) values ('M' || lpad(mem_seq.NEXTVAL, 3, '0'), '陳莉莉',  to_date('1996-06-24', 'yyyy-mm-dd'),  0,  '09-33486597',  'qqq@xxx.com',  '台北市內湖區仁愛路38號', 'alice', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW','alice', null);
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--建立後台假資料--
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--新增資料(後台管理員)
INSERT INTO EMPLOYEE (EMP_NO, EMP_NAME, EMP_ACCOUNT, EMP_PSW, EMP_NICKNAME, EMP_ACC_STATUS, EMP_EMAIL, EMP_PHOTO, EMP_ROLE, EMP_ARR_DATE) VALUES ('EMP' || LPAD(EMPLOYEE_SEQ.NEXTVAL, 3, '0'), '小元子', 'EA10350', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', '大元子', 0, 'st920202@gmail.com', NULL,'ROLE_ADMIN',TO_DATE('2019-08-08','YYYY-MM-DD'));
INSERT INTO EMPLOYEE (EMP_NO, EMP_NAME, EMP_ACCOUNT, EMP_PSW, EMP_NICKNAME, EMP_ACC_STATUS, EMP_EMAIL, EMP_PHOTO, EMP_ROLE, EMP_ARR_DATE) VALUES ('EMP' || LPAD(EMPLOYEE_SEQ.NEXTVAL, 3, '0'), '小群子', 'EA10311 ', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', '大群子', 0, 'dicky80126@gmail.com', NULL,'ROLE_STAFF',TO_DATE('2019-08-08','YYYY-MM-DD'));
INSERT INTO EMPLOYEE (EMP_NO, EMP_NAME, EMP_ACCOUNT, EMP_PSW, EMP_NICKNAME, EMP_ACC_STATUS, EMP_EMAIL, EMP_PHOTO, EMP_ROLE, EMP_ARR_DATE) VALUES ('EMP' || LPAD(EMPLOYEE_SEQ.NEXTVAL, 3, '0'), '小凱', 'EA10349', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', '大凱', 0, 'imrk85624@gmail.com', NULL,'ROLE_STAFF',TO_DATE('2019-08-08','YYYY-MM-DD'));
INSERT INTO EMPLOYEE (EMP_NO, EMP_NAME, EMP_ACCOUNT, EMP_PSW, EMP_NICKNAME, EMP_ACC_STATUS, EMP_EMAIL, EMP_PHOTO, EMP_ROLE, EMP_ARR_DATE) VALUES ('EMP' || LPAD(EMPLOYEE_SEQ.NEXTVAL, 3, '0'), '小旭子', 'EA10354', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', '大旭子', 0, 'conz8643@gmail.com', NULL,'ROLE_STAFF',TO_DATE('2019-08-08','YYYY-MM-DD'));
INSERT INTO EMPLOYEE (EMP_NO, EMP_NAME, EMP_ACCOUNT, EMP_PSW, EMP_NICKNAME, EMP_ACC_STATUS, EMP_EMAIL, EMP_PHOTO, EMP_ROLE, EMP_ARR_DATE) VALUES ('EMP' || LPAD(EMPLOYEE_SEQ.NEXTVAL, 3, '0'), '小晴子', 'EA10310', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', '大晴子', 0, 'doo8409255@gmail.com', NULL,'ROLE_STAFF',TO_DATE('2019-08-08','YYYY-MM-DD'));
INSERT INTO EMPLOYEE (EMP_NO, EMP_NAME, EMP_ACCOUNT, EMP_PSW, EMP_NICKNAME, EMP_ACC_STATUS, EMP_EMAIL, EMP_PHOTO, EMP_ROLE, EMP_ARR_DATE) VALUES ('EMP' || LPAD(EMPLOYEE_SEQ.NEXTVAL, 3, '0'), '小郁子', 'EA10326', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', '大郁子', 0, 'lizahung1008@gmail.com', NULL,'ROLE_ADMIN',TO_DATE('2019-08-08','YYYY-MM-DD'));
INSERT INTO EMPLOYEE (EMP_NO, EMP_NAME, EMP_ACCOUNT, EMP_PSW, EMP_NICKNAME, EMP_ACC_STATUS, EMP_EMAIL, EMP_PHOTO, EMP_ROLE, EMP_ARR_DATE) VALUES ('EMP' || LPAD(EMPLOYEE_SEQ.NEXTVAL, 3, '0'), '公主', 'EA10341', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', '領班', 0, 'ea103T41@gmail.com', NULL,'ROLE_STAFF',TO_DATE('2019-08-08','YYYY-MM-DD'));
INSERT INTO EMPLOYEE (EMP_NO, EMP_NAME, EMP_ACCOUNT, EMP_PSW, EMP_NICKNAME, EMP_ACC_STATUS, EMP_EMAIL, EMP_PHOTO, EMP_ROLE, EMP_ARR_DATE) VALUES ('EMP' || LPAD(EMPLOYEE_SEQ.NEXTVAL, 3, '0'), '頭目', 'EA10321', '$2a$10$WkyyZG43xrI/ry.VzZEbV.HRtIdcWEpnYHzN.N86KuudzEmULvKmW', '大師兄', 0, 'yuikou777@gmail.com', NULL,'ROLE_STAFF',TO_DATE('2019-08-08','YYYY-MM-DD'));

--新增資料(後台功能)

INSERT INTO BACKFUNCTION (FUN_NO, FUN_NAME) VALUES ('FNC' || LPAD(BACKFUNCTION_SEQ.NEXTVAL, 3, '0'), '托養管理');
INSERT INTO BACKFUNCTION (FUN_NO, FUN_NAME) VALUES ('FNC' || LPAD(BACKFUNCTION_SEQ.NEXTVAL, 3, '0'), '領養管理');
INSERT INTO BACKFUNCTION (FUN_NO, FUN_NAME) VALUES ('FNC' || LPAD(BACKFUNCTION_SEQ.NEXTVAL, 3, '0'), '會員權限設定');
INSERT INTO BACKFUNCTION (FUN_NO, FUN_NAME) VALUES ('FNC' || LPAD(BACKFUNCTION_SEQ.NEXTVAL, 3, '0'), '員工權限設定');
INSERT INTO BACKFUNCTION (FUN_NO, FUN_NAME) VALUES ('FNC' || LPAD(BACKFUNCTION_SEQ.NEXTVAL, 3, '0'), '員工管理');

--新增資料(管理員權限)
INSERT INTO EMP_AUTHORITY (EMP_NO, FUN_NO) VALUES ('EMP001', 'FNC003');
INSERT INTO EMP_AUTHORITY (EMP_NO, FUN_NO) VALUES ('EMP001', 'FNC002');
INSERT INTO EMP_AUTHORITY (EMP_NO, FUN_NO) VALUES ('EMP006', 'FNC002');
INSERT INTO EMP_AUTHORITY (EMP_NO, FUN_NO) VALUES ('EMP006', 'FNC001');
INSERT INTO EMP_AUTHORITY (EMP_NO, FUN_NO) VALUES ('EMP006', 'FNC003');
INSERT INTO EMP_AUTHORITY (EMP_NO, FUN_NO) VALUES ('EMP006', 'FNC004');
INSERT INTO EMP_AUTHORITY (EMP_NO, FUN_NO) VALUES ('EMP006', 'FNC005');
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
--建立領養假資料--
-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
-- INSERT INTO ADOPET (ADOPET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PET_WEIGHT,PET_CAT,PET_CHAR,LOCATION)
-- VALUES('A'||lpad(ADOPET_SEQ.NEXTVAL,3,'0'),'0','0','老三','米克斯','1',TO_DATE('2019-08-08','YYYY-MM-DD'),'6','4','有雙立耳、圓滾滾的眼睛','320桃園市中壢區中大路300號');
-- INSERT INTO ADOPET (ADOPET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PE_TWEIGHT,PET_CAT,LOCATION)
-- VALUES('A'||lpad(ADOPET_SEQ.NEXTVAL,3,'0'),'0','0','妞妞','米克斯','1',TO_DATE('2019-09-16','YYYY-MM-DD'),'4.5','3','404台中市北區健行路490號');
-- INSERT INTO ADOPET (ADOPET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PE_TWEIGHT,PET_CAT,LOCATION)
-- VALUES('A'||lpad(ADOPET_SEQ.NEXTVAL,3,'0'),'0','0','蜜奇','貴賓','0',TO_DATE('2013-09-16','YYYY-MM-DD'),'5.5','4','812高雄市小港區松和路1號');
-- INSERT INTO ADOPET (ADOPET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PE_TWEIGHT,PET_CAT,LOCATION)
-- VALUES('A'||lpad(ADOPET_SEQ.NEXTVAL,3,'0'),'0','0','小黑','拉布拉多','0',TO_DATE('2010-09-16','YYYY-MM-DD'),'16','5','812高雄市小港區松和路1號');
-- INSERT INTO ADOPET (ADOPET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PET_WEIGHT,PET_CAT,PET_CHAR,LOCATION)
-- VALUES('A'||lpad(ADOPET_SEQ.NEXTVAL,3,'0'),'0','0','Green','狐狸犬','0',TO_DATE('2018-03-06','YYYY-MM-DD'),'10','4','柔亮蓬鬆的白毛、充滿微笑的Green，十分俊帥','320桃園市中壢區中大路300號');
-- INSERT INTO ADOPET (ADOPET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PET_WEIGHT,PET_CAT,PET_CHAR,LOCATION)
-- VALUES('A'||lpad(ADOPET_SEQ.NEXTVAL,3,'0'),'0','0','Yummy','米格魯','1',TO_DATE('2019-09-17','YYYY-MM-DD'),'13','5','窈窕身材和修長的四肢','320桃園市中壢區中大路300號');
-- INSERT INTO ADOPET (ADOPET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PE_TWEIGHT,PET_CAT,LOCATION)
-- VALUES('A'||lpad(ADOPET_SEQ.NEXTVAL,3,'0'),'0','0','巧巧','米克斯','0',TO_DATE('2019-08-31','YYYY-MM-DD'),'12','5','812高雄市小港區松和路1號');
-- INSERT INTO ADOPET (ADOPET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PE_TWEIGHT,PET_CAT,LOCATION)
-- VALUES('A'||lpad(ADOPET_SEQ.NEXTVAL,3,'0'),'0','0','Qbo','拉布拉多','0',TO_DATE('2019-07-31','YYYY-MM-DD'),'20','6','404台中市北區健行路490號');
-- INSERT INTO ADOPET (ADOPET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PE_TWEIGHT,PET_CAT,LOCATION)
-- VALUES('A'||lpad(ADOPET_SEQ.NEXTVAL,3,'0'),'0','0','錢寶','比利時狼犬','0',TO_DATE('2017-07-31','YYYY-MM-DD'),'20','6','404台中市北區健行路490號');
-- INSERT INTO ADOPET (ADOPET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PE_TWEIGHT,PET_CAT,LOCATION)
-- VALUES('A'||lpad(ADOPET_SEQ.NEXTVAL,3,'0'),'0','0','比特媽媽','比特犬','0',TO_DATE('2018-12-31','YYYY-MM-DD'),'10','5','812高雄市小港區松和路1號');
-- INSERT INTO ADOPET (ADOPET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PE_TWEIGHT,PET_CAT,LOCATION)
-- VALUES('A'||lpad(ADOPET_SEQ.NEXTVAL,3,'0'),'0','1','傑克','混種貓','0',TO_DATE('2016-12-31','YYYY-MM-DD'),'7','1','320桃園市中壢區中大路300號');
-- INSERT INTO ADOPET (ADOPET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PE_TWEIGHT,PET_CAT,LOCATION)
-- VALUES('A'||lpad(ADOPET_SEQ.NEXTVAL,3,'0'),'0','1','黑魯魯','混種貓','0',TO_DATE('2015-12-31','YYYY-MM-DD'),'7.5','1','320桃園市中壢區中大路300號');
-- INSERT INTO ADOPET (ADOPET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PET_WEIGHT,PET_CAT,PET_CHAR,LOCATION)
-- VALUES('A'||lpad(ADOPET_SEQ.NEXTVAL,3,'0'),'0','1','小朋友','混種貓','1',TO_DATE('2020-09-17','YYYY-MM-DD'),'7.5','1','毛色為虎斑的橘貓','320桃園市中壢區中大路300號');
-- INSERT INTO ADOPET (ADOPET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PE_TWEIGHT,PET_CAT,LOCATION)
-- VALUES('A'||lpad(ADOPET_SEQ.NEXTVAL,3,'0'),'0','0','饅頭','法鬥','0',TO_DATE('2019-07-03','YYYY-MM-DD'),'7','4','812高雄市小港區松和路1號');
-- INSERT INTO ADOPET (ADOPET_NO,ADO_STATUS,PET_TYPE,PET_NAME,PET_BREED,PET_SEX,PET_BIRTH,PET_WEIGHT,PET_CAT,PET_CHAR,LOCATION)
-- VALUES('A'||lpad(ADOPET_SEQ.NEXTVAL,3,'0'),'0','1','娜娜','混種貓','1',TO_DATE('2020-10-30','YYYY-MM-DD'),'5','1','毛色為黑白乳牛的貓','812高雄市小港區松和路1號');


-- INSERT INTO ADOPETFOLLOW(MEM_NO, ADOPET_NO)
-- VALUES ('M007','A014');
-- INSERT INTO ADOPETFOLLOW(MEM_NO, ADOPET_NO)
-- VALUES ('M001','A011');
-- INSERT INTO ADOPETFOLLOW(MEM_NO, ADOPET_NO)
-- VALUES ('M004','A001');
-- INSERT INTO ADOPETFOLLOW(MEM_NO, ADOPET_NO)
-- VALUES ('M015','A005');
-- INSERT INTO ADOPETFOLLOW(MEM_NO, ADOPET_NO)
-- VALUES ('M015','A015');


-- INSERT INTO ADORESERVATION(RESERVATION_NO,ADOPET_NO,MEM_NO,VISIT_DATE,RESERVATION_STATUS)
-- VALUES ('R'||lpad(ADORESERVATION_SEQ.NEXTVAL,3,'0'),'A015','M015',TO_DATE('2020-9-30','YYYY-MM-DD'),'0');
-- INSERT INTO ADORESERVATION(RESERVATION_NO,ADOPET_NO,MEM_NO,VISIT_DATE,RESERVATION_STATUS)
-- VALUES ('R'||lpad(ADORESERVATION_SEQ.NEXTVAL,3,'0'),'A001','M004',TO_DATE('2020-11-15','YYYY-MM-DD'),'0');
-- INSERT INTO ADORESERVATION(RESERVATION_NO,ADOPET_NO,MEM_NO,VISIT_DATE,RESERVATION_STATUS)
-- VALUES ('R'||lpad(ADORESERVATION_SEQ.NEXTVAL,3,'0'),'A014','M007',TO_DATE('2020-11-13','YYYY-MM-DD'),'0');
-- INSERT INTO ADORESERVATION(RESERVATION_NO,ADOPET_NO,MEM_NO,VISIT_DATE,RESERVATION_STATUS)
-- VALUES ('R'||lpad(ADORESERVATION_SEQ.NEXTVAL,3,'0'),'A002','M001',TO_DATE('2020-11-14','YYYY-MM-DD'),'0');
-- INSERT INTO ADORESERVATION(RESERVATION_NO,ADOPET_NO,MEM_NO,VISIT_DATE,RESERVATION_STATUS)
-- VALUES ('R'||lpad(ADORESERVATION_SEQ.NEXTVAL,3,'0'),'A003','M012',TO_DATE('2020-11-20','YYYY-MM-DD'),'0');


-- INSERT INTO ADOPETALBUM(ADOPIC_NO,ADOPET_NO)
-- VALUES ('AP'||lpad(ADOPETALBUM_SEQ.NEXTVAL,3,'0'),'A001');
-- INSERT INTO ADOPETALBUM(ADOPIC_NO,ADOPET_NO)
-- VALUES ('AP'||lpad(ADOPETALBUM_SEQ.NEXTVAL,3,'0'),'A002');
-- INSERT INTO ADOPETALBUM(ADOPIC_NO,ADOPET_NO)
-- VALUES ('AP'||lpad(ADOPETALBUM_SEQ.NEXTVAL,3,'0'),'A003');


commit;
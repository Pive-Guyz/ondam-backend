DROP TABLE IF EXISTS `trouble_summary`;
DROP TABLE IF EXISTS `effective_statement`;
DROP TABLE IF EXISTS `shortened_counsel`;
DROP TABLE IF EXISTS `emotion_analysis`;
DROP TABLE IF EXISTS `emotion`;
DROP TABLE IF EXISTS `emotion_category`;
DROP TABLE IF EXISTS `analysis`;
DROP TABLE IF EXISTS `report`;
DROP TABLE IF EXISTS `report_category`;
DROP TABLE IF EXISTS `reply`;
DROP TABLE IF EXISTS `diary_record`;
DROP TABLE IF EXISTS `diary`;
DROP TABLE IF EXISTS `counsel`;
DROP TABLE IF EXISTS `counselee`;
DROP TABLE IF EXISTS `member`;

CREATE TABLE member (
                        id	BIGINT	NOT NULL  AUTO_INCREMENT PRIMARY KEY,
                        name	VARCHAR(255)	NOT NULL,
                        email	VARCHAR(255)	NOT NULL UNIQUE,
                        password	VARCHAR(255)	NOT NULL,
                        birthday	VARCHAR(255)	NOT NULL,
                        created_at	DATETIME	NOT NULL	DEFAULT NOW(),
                        deleted_at	DATETIME	NULL,
                        phone	VARCHAR(255)	NOT NULL,
                        profile_image_url	VARCHAR(255)	NULL,
                        address	VARCHAR(255)	NULL,
                        point	BIGINT	NOT NULL,
                        authority	VARCHAR(255)	NOT NULL	DEFAULT 'USER',
                        is_banned	VARCHAR(4)	NOT NULL	DEFAULT 'N',
                        is_diary_blocked	VARCHAR(4)	NOT NULL	DEFAULT 'N'
);

INSERT INTO member (id, name, email, password, birthday, created_at, deleted_at, phone, profile_image_url, address, point, authority, is_banned, is_diary_blocked)
VALUES
    (1,'김수민','e0ifd0tvbdi@hotmail.com','bmOHnKYaXRvj','1985-02-03','2023-10-14 06:44:15',NULL,'010-7224-2584',NULL,'부산광역시 영등포구 도산대1길',30,'ADMIN','Y','N'),
    (2, '조영호', 'ckw5ngcx1@gmail.com', '11xCZkwPRQeN', '1992-12-08', '2024-10-31 01:21:38',NULL , '010-3677-8573', NULL, '충청남도 삼척시 압구정6거리 (성진성이동)', 40, 'GUEST', 'N', 'Y'),
    (3, '이성현', 'ljh75lxo6qji@hotmail.com', 'HUAKw9iEU1jj', '1988-10-03', '2023-11-15 08:48:50', NULL, '010-7304-7252', NULL, '제주특별자치도 부천시 소사구 학동495길 (동현김면)', 50, 'GUEST', 'N', 'N'),
    (4, '고채원', 'jxepq85jsg65@daum.net', '0Fmxk754LEgw', '1984-04-02', '2024-02-13 03:51:15', NULL, '010-4946-2290', NULL, '전라남도 동두천시 영동대4로 (미정김리)', 10, 'USER', 'N', 'N'),
    (5, '진재현', 'fsv871yzoy@daum.net', 'BGhnuKoneNo4', '1985-02-17', '2024-06-29 12:05:00', NULL, '010-4899-5562', NULL, '서울특별시 성북구 삼성가 (민재백최면)', 40, 'USER', 'N', 'Y'),
    (6, '박중수', 'dxmo5bx@gmail.com', 'dTXglHilC2eY', '1992-02-02', '2024-09-04 05:24:54', NULL, '010-9856-1241', NULL, '충청북도 시흥시 언주거리 (지원이김읍)', 10, 'USER', 'Y', 'Y'),
    (7, '김명숙', 'fao72k@hotmail.com', 'PElndTdtdD5G', '1976-09-03', '2023-07-18 01:47:44', NULL, '010-4044-2122', NULL, '충청북도 청주시 흥덕구 백제고분6가', 50, 'USER', 'N', 'N'),
    (8, '박선영', 'wpvs7h@daum.net', 'oyPstUeC99en', '1983-03-12', '2024-06-26 14:39:57', NULL, '010-2127-5002', NULL, '부산광역시 서초구 가락14가', 30, 'USER', 'N', 'N'),
    (9, '장순자', '5rtwiykid91@gmail.com', 'BR4cXsxjGJXk', '1977-10-28', '2024-07-01 18:46:22', '2024-09-22 19:02:42', '010-7267-4945', NULL, '충청북도 구리시 역삼가 (성훈유리)', 40, 'USER', 'N', 'Y'),
    (10, '문지원', 'qktc89k8yqk9@kakao.com', 'gxwsRbZya1W8', '1994-12-16', '2023-11-17 03:24:24', '2024-09-16 01:39:27', '010-5689-4770', NULL, '강원도 수원시 장안구 서초중앙길', 50, 'USER', 'N', 'N');

# ========================== 회원 테이블




CREATE TABLE `counselee` (
                             `id`	BIGINT	NOT NULL PRIMARY KEY AUTO_INCREMENT,
                             `name`	VARCHAR(255)	NOT NULL,
                             `birthday`	VARCHAR(255)	NOT NULL,
                             `gender`	VARCHAR(4)	NOT NULL,
                             `phone`	VARCHAR(255)	NOT NULL,
                             `eme_phone`	VARCHAR(255)	NULL,
                             `address`	VARCHAR(255)	NOT NULL,
                             `severity_level`	INT	NULL,
                             `created_at`	DATETIME	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
                             `deleted_at`	DATETIME	NULL,
                             `updated_at`	DATETIME	NULL,
                             `end_date`	DATETIME	NULL,
                             `end_reason`	LONGTEXT	NULL,
                             `member_id`	BIGINT	NOT NULL,
                             FOREIGN KEY (`member_id`) REFERENCES `member`(`id`)
);

INSERT INTO `counselee`
(`name`, `birthday`, `gender`, `phone`, `eme_phone`, `address`, `severity_level`, `created_at`, `deleted_at`, `updated_at`, `end_date`, `end_reason`, `member_id`)
VALUES
    ('김지현', '1990-05-23', 'F', '010-1234-5678', '010-8765-4321', '서울시 강남구', 2, NOW(), NULL, NULL, NULL, NULL, 1),
    ('이민준', '1988-11-14', 'M', '010-2345-6789', NULL, '경기도 수원시', 3, NOW(), NULL, NULL, NULL, NULL, 2),
    ('박서연', '2001-03-08', 'F', '010-3456-7890', '010-1111-2222', '부산시 해운대구', 1, NOW(), NULL, NULL, NULL, NULL, 3),
    ('최지우', '1995-07-30', 'F', '010-4567-8901', NULL, '대구시 달서구', 4, NOW(), NULL, NULL, '2024-12-15 10:00:00', '상담 목표 달성', 4),
    ('정우성', '1985-02-18', 'M', '010-5678-9012', '010-3333-4444', '인천시 연수구', NULL, NOW(), NULL, NULL, NULL, NULL, 5),
    ('한예린', '1999-06-02', 'F', '010-6789-0123', NULL, '광주시 북구', 2, NOW(), NULL, NULL, NULL, NULL, 1),
    ('남지민', '2000-09-25', 'M', '010-7890-1234', '010-5555-6666', '경상남도 창원시', 3, NOW(), NULL, NULL, NULL, NULL, 2),
    ('오세훈', '1993-12-12', 'M', '010-8901-2345', NULL, '전주시 완산구', 1, NOW(), NULL, NULL, NULL, NULL, 3),
    ('윤소희', '1997-01-05', 'F', '010-9012-3456', NULL, '충청북도 청주시', 5, NOW(), NULL, NULL, NULL, NULL, 4),
    ('백현우', '1982-04-10', 'M', '010-0123-4567', '010-7777-8888', '제주시', 4, NOW(), NULL, NULL, '2025-01-10 15:00:00', '개인 사정으로 종료', 5);

# ========================== 내담자 테이블



CREATE TABLE counsel (
                         id	BIGINT	NOT NULL AUTO_INCREMENT PRIMARY KEY,
                         created_at	DATETIME	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
                         next_created_at DATETIME NULL DEFAULT CURRENT_TIMESTAMP,
                         content	LONGTEXT	NOT NULL,
                         opinion	LONGTEXT	NOT NULL,
                         weather	VARCHAR(255)	NOT NULL,
                         counsel_type VARCHAR(255) NOT NULL,
                         time VARCHAR(255) NOT NULL,
                         deleted_at	DATETIME	NULL,
                         counselee_id	BIGINT	NOT NULL,
                         member_id	BIGINT	NOT NULL,

                         FOREIGN KEY (`counselee_id`) REFERENCES `counselee`(`id`),
                         FOREIGN KEY (`member_id`) REFERENCES `member`(`id`));

INSERT INTO `counsel` (`created_at`, `next_created_at`,`content`, `opinion`, `weather`, `counsel_type`, `time`,`deleted_at`, `counselee_id`, `member_id`)
VALUES ('2025-02-01 10:52:17',
        '2025-02-08 10:52:17',
        '내담자: 요즘 직장에서 너무 스트레스를 받아요. 상사와의 갈등이 심해서 출근하기가 싫어요.\n상담자: 구체적으로 어떤 상황에서 갈등을 느끼셨는지 이야기해 주실 수 있을까요?\n내담자: 제가 보고서를 제출했는데, 제대로 읽어보지도 않고 막 혼을 내셨어요.\n상담자: 상사의 그런 반응이 예상 밖이었겠네요. 그때 어떤 감정을 느끼셨나요?\n내담자: 억울하고 무기력했어요. 제가 한 노력을 전혀 인정받지 못한 기분이었죠.\n상담자: 그런 감정은 당연하다고 느껴져요. 그 상황에서 어떻게 대처하셨나요?\n내담자: 그냥 “죄송합니다”라고만 했어요. 속으로는 정말 울고 싶었지만요.\n상담자: 감정을 억누르며 대응하는 게 쉽지 않았을 것 같아요. 평소에도 이런 일이 자주 있나요?\n내담자: 네, 실수가 없어도 늘 불만이 있는 듯한 태도로 대해요. 항상 긴장하게 돼요.\n상담자: 계속 긴장된 상태로 일하는 건 몸과 마음 모두 지칠 수 있어요. 요즘 신체적으로도 변화가 있나요?\n내담자: 네, 잠도 잘 안 오고 밥맛도 없어요. 아침에 일어나는 게 너무 힘들어요.\n상담자: 그 정도면 스트레스가 많이 누적된 상태 같아요. 혹시 회사 밖에서 푸는 방법은 있나요?\n내담자: 예전엔 운동을 했는데, 요즘은 그럴 기운도 없어요. 퇴근하면 그냥 누워있어요.\n상담자: 그만큼 마음이 지쳐 있다는 신호 같아요. 혹시 상사 외에 편하게 이야기할 수 있는 사람이 있나요?\n내담자: 회사에서는 거의 없고, 친구들한테도 자세히 말하진 않았어요. 그냥 참고 넘기려 했어요.\n상담자: 지금 이렇게 이야기해 주셔서 고마워요. 말하는 것 자체가 이미 중요한 시작이에요.\n내담자: 이런 이야기를 들어주는 사람이 있다는 게 좀 위로가 되네요.\n상담자: 그렇게 느끼셨다니 다행이에요. 앞으로도 이런 감정을 나눌 수 있는 공간이 되길 바래요.\n내담자: 감사합니다. 조금은 가벼워진 느낌이에요.\n상담자: 앞으로는 스트레스를 덜 받도록 구체적인 대처 방법도 함께 찾아보면 좋겠어요.',
        '직장에서의 대인관계 갈등으로 인해 내담자의 정서적 스트레스가 높아 보임. 지속적인 스트레스 관리와 감정 표현 훈련이 필요함.',
        '흐림',
        '스트레스',
        '14:00',
        null,
        2,
        2),
(
  '2025-03-15 14:30:00',
  '2025-03-22 14:30:00',
  '내담자: 요즘 너무 무기력하고 아무것도 하기 싫어요. 하루 종일 누워만 있고 싶어요.\n상담자: 무기력함이 계속되고 있군요. 그 감정은 언제부터 시작된 것 같나요?\n내담자: 한 두 달 전부터였던 것 같아요. 이유는 잘 모르겠어요. 그냥 모든 게 귀찮아졌어요.\n상담자: 예전에는 어땠나요? 뭔가 즐거움을 느낄 수 있는 활동이 있었나요?\n내담자: 친구들이랑 영화 보러 가거나 혼자 여행도 자주 다녔어요.\n상담자: 그런 활동들이 지금은 전혀 하고 싶지 않은가요?\n내담자: 네, 그냥 집에만 있고 싶고 사람 만나는 것도 피하게 돼요.\n상담자: 요즘 수면이나 식사는 어떠세요?\n내담자: 잠도 자꾸 깨고 식욕도 없어요. 배가 고픈데 먹고 싶지가 않아요.\n상담자: 몸과 마음이 모두 지쳐 있는 상태인 것 같아요. 혹시 주변에 지금 마음을 털어놓을 수 있는 사람이 있나요?\n내담자: 딱히 없는 것 같아요. 다들 바쁘고 저도 말 꺼내기 조심스러워요.\n상담자: 지금 이 자리에서 이야기해 주셔서 감사해요. 마음속 이야기들을 나누는 것만으로도 큰 의미가 있어요.\n내담자: 이런 이야기 할 곳이 없었는데, 그냥 말하면서 눈물이 났어요.\n상담자: 그 감정이 흘러나오는 것도 자연스러운 과정이에요. 우리 함께 이 감정을 어떻게 다룰 수 있을지 찾아가요.',
  '내담자는 장기간 무기력함과 사회적 고립감을 경험 중이며, 우울 증상이 의심됨. 감정 표현을 유도하며 일상 활동을 천천히 회복할 수 있도록 단계적 접근이 필요함.',
  '맑음',
  '인간관계',
  '15:30',
  NULL,
  4,
  4
),
(
  '2025-03-29 11:00:00',
  '2025-04-05 11:00:00',
  '내담자: 최근에 가족과의 갈등이 심해졌어요. 특히 부모님과의 대화가 너무 힘들어요.\n상담자: 어떤 상황에서 갈등이 주로 발생하나요?\n내담자: 제가 진로에 대해 고민이 많아서 이야기를 꺼냈는데, 부모님은 무조건 안정적인 직장을 강요하세요.\n상담자: 내담자님의 생각과 부모님의 기대 사이에 차이가 큰 상황이군요. 그때 어떤 감정을 느끼셨나요?\n내담자: 답답하고 외롭고... 제가 이해받지 못한다는 느낌이었어요.\n상담자: 그런 감정이 반복되면 심리적으로 큰 부담이 될 수 있어요. 그 이후로 부모님과의 관계는 어땠나요?\n내담자: 대화를 피하게 됐어요. 얼굴을 마주치는 것도 피하게 되고요.\n상담자: 가족 내의 의사소통 단절은 관계를 더 어렵게 만들 수 있어요. 혹시 이런 감정을 다른 사람과 나눠보신 적 있나요?\n내담자: 친구 한두 명한테는 말했는데, 가족 얘기는 왠지 조심스러워요.\n상담자: 충분히 그럴 수 있어요. 이 자리에서는 그런 부담 없이 이야기하셔도 됩니다.\n내담자: 그런 말 들으니까 조금 마음이 편해지네요.\n상담자: 그 마음을 지켜드릴게요. 우리가 함께 상황을 정리해보고, 부모님과 건강하게 대화하는 방법도 찾아볼 수 있어요.',
  '가족과의 진로 문제로 갈등을 겪고 있으며, 관계 단절과 정서적 고립감을 호소함. 감정 표현 훈련과 더불어 가족과의 의사소통 개선을 위한 전략이 필요함.',
  '흐림',
  '가족관계',
  '11:00',
  NULL,
  6,
  1
);

# ========================== 상담 테이블



CREATE TABLE `diary` (
                         `id`	BIGINT	NOT NULL	PRIMARY KEY AUTO_INCREMENT,
                         `title` VARCHAR(255)	NOT NULL,
                         `content`	LONGTEXT	NOT NULL,
                         `created_at`	DATETIME	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
                         `deleted_at`	DATETIME	NULL,
                         `is_blinded`	VARCHAR(4)	NOT NULL	DEFAULT 'N'	,
                         `member_id`	BIGINT	NOT NULL,
                         FOREIGN KEY(`member_id`) REFERENCES `member`(`id`)
);

INSERT INTO `diary` (`title`, `content`, `created_at`, `deleted_at`, `is_blinded`, `member_id`) VALUES
-- 일기 1
('마음이 무거웠던 하루',
 '오늘 내담자 중 한 분이 퇴사를 고민하고 있다는 이야기를 꺼냈다. 직장 내 상사와의 갈등으로 인해 자존감이 매우 낮아진 상태였다. 상담 내내 감정을 억누르려는 모습이 안쓰러웠다. 더욱 조심스럽게 질문하고 공감하려 노력했다. 나 역시 괜히 마음이 무거워지는 날이었다.',
 '2025-04-22 21:13:00', NULL, 'N', 3),

-- 일기 2
('작은 변화의 시작',
 '매주 찾아오는 내담자가 오늘 처음으로 스스로의 감정을 “조금은 덜 무기력하다”고 표현했다. 아주 사소한 말이었지만, 나는 그 말에서 큰 의미를 느꼈다. 상담사의 말 한마디, 표정 하나에도 큰 영향을 미칠 수 있다는 것을 다시금 느꼈다.',
 '2025-04-21 18:42:00', NULL, 'N', 7),

-- 일기 3
('오랜만에 웃음을',
 '오늘 상담 중 한 내담자가 웃으며 농담을 건넸다. 몇 주 전까지만 해도 표정 하나 없이 앉아있던 그였기에, 그 미소가 정말 반가웠다. 진심 어린 공감이 전해진 결과일까? 상담사로서 보람을 느끼는 순간이었다.',
 '2025-04-20 10:05:00', NULL, 'N', 10),

('지워진 일기',
 '이 일기는 삭제됐습니다.',
 '2025-04-01 10:10:10', '2025-04-02 10:10:10', 'N', 1),
('블라인드 된 일기',
 '이 일기는 블라인드 처리 되었습니다.',
 '2025-01-01 01:01:01',NULL,'Y',1);;

# ========================== 일기 테이블



CREATE TABLE `diary_record` (
                                `id`	BIGINT	NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                `diary_id`	BIGINT	NOT NULL,
                                `sender_id`	BIGINT	NOT NULL,
                                `receiver_id` BIGINT NOT NULL,
                                `is_expired`	VARCHAR(4)	NOT NULL	DEFAULT 'N',
                                FOREIGN KEY(`diary_id`) REFERENCES `diary`(`id`),
                                FOREIGN KEY(`sender_id`) REFERENCES `member`(`id`),
                                FOREIGN KEY(`receiver_id`) REFERENCES `member`(`id`)
);

INSERT INTO `diary_record` (`diary_id`, `sender_id`,`receiver_id`, `is_expired`) VALUES
-- diary_id 1 전송
(1, 3,4, 'N'),
(1, 3,5, 'N'),
(1, 3,6, 'N'),

-- diary_id 2 전송
(2, 7,4, 'N'),
(2, 7,5, 'N'),
(2, 7,6, 'N'),

-- diary_id 3 전송
(3, 10,4, 'N'),
(3, 10,5, 'N'),
(3, 10,6, 'N');

# ========================== 일기 발송 기록 테이블



CREATE TABLE `reply` (
                         `id`	BIGINT	NOT NULL	PRIMARY KEY AUTO_INCREMENT,
                         `title`	VARCHAR(255)	NOT NULL,
                         `content`	VARCHAR(255)	NOT NULL,
                         `created_at`	DATETIME	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
                         `deleted_at`	DATETIME	NULL,
                         `is_blinded`	VARCHAR(4)	NOT NULL	DEFAULT 'N',
                         `diary_record_id`	BIGINT	NOT NULL,
                         `sender_id`	BIGINT	NOT NULL,
                         `receiver_id`	BIGINT	NOT NULL,
                         FOREIGN KEY(`diary_record_id`) REFERENCES `diary_record`(`id`),
                         FOREIGN KEY(`sender_id`) REFERENCES `member`(`id`),
                         FOREIGN KEY(`receiver_id`) REFERENCES `member`(`id`)
);

INSERT INTO `reply` (`title`, `content`, `created_at`, `is_blinded`, `diary_record_id`, `sender_id`,`receiver_id`)
VALUES
    ('오늘 일기 잘 읽었어요', '하루가 정말 힘드셨을 것 같아요. 내일은 조금 더 나은 하루가 되시길 바라요.', NOW(), 'N', 1, 4,3),
    ('응원의 메시지!', '많이 지치셨을 텐데도 잘 이겨내고 계시네요. 대단하세요.', NOW(), 'N', 2, 5,3),
    ('감사 인사', '오늘 공유해 주신 이야기가 참 따뜻했어요. 덕분에 저도 생각이 많아졌어요.', NOW(), 'N', 3, 6,3),

    ('마음에 와 닿았어요', '오늘 일기 중에서 “작은 것에도 감사”라는 말이 참 좋았어요.', NOW(), 'N', 4, 4,7),
    ('힘내세요!', '매일 최선을 다하는 모습이 멋집니다. 꼭 좋은 결과가 있을 거예요.', NOW(), 'N', 5, 5,7),
    ('함께 공감해요', '저도 비슷한 경험이 있어서 더 공감되네요. 힘내세요!', NOW(), 'N', 6, 6,7),

    ('좋은 글 감사합니다', '마음이 차분해지는 글이었어요. 저도 오늘은 일기 써봐야겠어요.', NOW(), 'N', 7, 4,10),
    ('배운 게 많아요', '오늘 공유해주신 내용에서 많은 걸 느꼈습니다. 감사합니다.', NOW(), 'N', 8, 5,10),
    ('응원합니다!', '따뜻한 하루 보내시길 진심으로 바랍니다.', NOW(), 'N', 9, 6,10);

# ========================== 답장 테이블



CREATE TABLE `report_category` (
                                   `id`	BIGINT	PRIMARY KEY NOT NULL	AUTO_INCREMENT,
                                   `name`	VARCHAR(255)	NOT NULL,
                                   `deleted_at`	DATETIME	NULL
);

INSERT INTO `report_category` (`name`)
VALUES
    ('욕설 및 비하 발언'),
    ('성적 불쾌감을 유발하는 내용'),
    ('폭력적인 언행'),
    ('스팸 또는 광고'),
    ('개인 정보 노출'),
    ('허위 사실 유포'),
    ('도배성 메시지'),
    ('불쾌한 이미지 또는 파일 첨부'),
    ('타인 사칭'),
    ('기타 부적절한 행동');


# ========================== 신고 사유 테이블



CREATE TABLE `report` (
                          `id`	BIGINT	NOT NULL	PRIMARY KEY AUTO_INCREMENT,
                          `reason`	LONGTEXT	NULL,
                          `created_at`	DATETIME	NOT NULL	DEFAULT CURRENT_TIMESTAMP,
                          `status`	TINYINT   NOT NULL DEFAULT 0,
                          `deleted_at`	DATETIME	NULL,
                          `member_id`	BIGINT	NOT NULL,
                          `reported_member_id` BIGINT NOT NULL,
                          `diary_id`	BIGINT	NULL,
                          `reply_id`	BIGINT	NULL,
                          `report_category_id`	BIGINT	NOT NULL,
                          FOREIGN KEY(`member_id`) REFERENCES `member`(`id`),
                          FOREIGN KEY(`reported_member_id`) REFERENCES `member`(`id`),
                          FOREIGN KEY(`diary_id`) REFERENCES `diary`(`id`),
                          FOREIGN KEY(`reply_id`) REFERENCES `reply`(`id`),
                          FOREIGN KEY(`report_category_id`) REFERENCES `report_category`(`id`)
);

INSERT INTO `report` (
    `reason`,
    `created_at`,
    `status`,
    `deleted_at`,
    `member_id`,
    `reported_member_id`,
    `diary_id`,
    `reply_id`,
    `report_category_id`
)
VALUES
-- diary_id 1번, member_id 3이 작성한 일기를 신고 (신고자는 예시로 member_id 5로)
('해당 일기에 부적절한 언어가 포함되어 있습니다.', NOW(), 0, NULL, 5,3, 1, NULL, 3),

-- reply_id 1번, member_id 4가 작성한 답장을 신고 (신고자는 예시로 member_id 3으로)
('답장 내용이 공격적으로 느껴졌습니다.', NOW(), 0, NULL, 3,4, NULL, 1, 1);

# ========================== 신고 테이블



CREATE TABLE `analysis` (
                            `id`	BIGINT	NOT NULL PRIMARY KEY AUTO_INCREMENT,
                            `counsel_id`	BIGINT	NOT NULL,
                            FOREIGN KEY(`counsel_id`) REFERENCES `counsel`(`id`)
);

INSERT INTO `analysis` (
    `counsel_id`
)
VALUES (1),(2),(3);

# ========================== 분석 테이블

CREATE TABLE `effective_statement` (
                                       `id`	BIGINT	NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                       `content`	TEXT	NOT NULL,
                                       `reason`	TEXT	NOT NULL,
                                       `response`	TEXT	NOT NULL,
                                       `result`	TEXT	NOT NULL,
                                       `analysis_id`	BIGINT	NOT NULL,
                                       FOREIGN KEY (`analysis_id`) REFERENCES `analysis`(`id`)
);

INSERT INTO `effective_statement` (`content`, `reason`, `response`, `result`, `analysis_id`)
VALUES (
           '마음이 따라오지 않을 땐, 그 마음 그대로 인정해주는 게 시작일 수 있어요.',
           '[
               "상대방의 마음을 진실하게 인정하는 것은 존중과 위로가 되어 상대방의 심리적 안정에 도움이 될 수 있음",
               "자신의 감정을 숨기지 않고 솔직히 표현하도록 유도하여 속마음을 털어놓을 수 있게 돕는 역할을 함",
               "감정을 거부하지 않고 수용함으로써 내담자가 스스로에 대해 자각하고 받아들일 수 있도록 도와줄 수 있음"
           ]',
           '[
               "그런가요… 제가 너무 나약한 건 아닌가요?",
               "음… 그렇게 생각해본 적은 없어요."
           ]',
           '내담자의 부정적인 감정을 거부하지 않고 수용함으로써 내담자가 처한 상황을 원인과 함께 다시 생각해보게 하고 긍정적인 변화를 이끌어내는 역할을 함',
           1
       );

# ========================== 효과적 발화 테이블

CREATE TABLE `trouble_summary` (
                                   `id`	BIGINT	NOT NULL	PRIMARY KEY AUTO_INCREMENT,
                                   `period`	VARCHAR(255)	NOT NULL,
                                   `place`	VARCHAR(255)	NOT NULL,
                                   `situation`	VARCHAR(255)	NOT NULL,
                                   `reason`	VARCHAR(255)	NOT NULL,
                                   `flow`	VARCHAR(255)	NOT NULL,
                                   `determination`	VARCHAR(255)	NOT NULL,
                                   `analysis_id`	BIGINT	NOT NULL,
                                   FOREIGN KEY (`analysis_id`) REFERENCES `analysis`(`id`)
);

INSERT INTO `trouble_summary` (
    `period`,
    `place`,
    `situation`,
    `reason`,
    `flow`,
    `determination`,
    `analysis_id`
) VALUES (
             '최근 몇 주 간',
             '직장 내',
             '상사의 반복적인 질책과 무시로 인한 갈등 상황',
             '노력과 결과를 인정받지 못하고 억울함과 무기력을 느낀 것',
             '보고서 제출 후 상사의 부당한 질책 → 억울함과 무기력감 → 감정을 억누르고 사과함 → 지속적 긴장 상태 → 수면장애와 식욕저하 발생 → 사회적 지지 부족',
             '심리적 스트레스가 누적된 상태이며, 감정 표현과 스트레스 해소 방법의 필요성이 강조됨',
             1
         );

# ========================== 고민 요약 테이블

CREATE TABLE `emotion_category` (
                                    `id` BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
                                    `name` VARCHAR(255) NOT NULL
);

INSERT INTO `emotion_category` (`name`) VALUES
                                            ('긍정적'),
                                            ('부정적'),
                                            ('중립/혼합'),
                                            ('성장/회복'),
                                            ('대인관계');

# ========================== 감정 카테고리 테이블



CREATE TABLE `emotion` (
                           `id`	BIGINT	NOT NULL	PRIMARY KEY AUTO_INCREMENT,
                           `name`	VARCHAR(255)	NOT NULL,
                           `emotion_category_id`	BIGINT	NOT NULL,
                           FOREIGN KEY(`emotion_category_id`) REFERENCES `emotion_category`(`id`)
);

INSERT INTO `emotion` (`name`, `emotion_category_id`) VALUES
-- 긍정적 감정 (1)
('기쁨', 1),
('안도', 1),
('감사', 1),
('감동', 1),
('기대', 1),
('희망', 1),
('편안함', 1),
('자신감', 1),
('활력', 1),

-- 부정적 감정 (2)
('불안', 2),
('분노', 2),
('짜증', 2),
('우울', 2),
('슬픔', 2),
('외로움', 2),
('수치심', 2),
('죄책감', 2),
('후회', 2),
('좌절', 2),
('무기력', 2),
('혼란', 2),

-- 중립/혼합 감정 (3)
('멍함', 3),
('무감각', 3),
('갈등', 3),
('복잡함', 3),
('모호함', 3),

-- 성장/회복 감정 (4)
('회복', 4),
('안정감', 4),
('수용', 4),
('성장', 4),
('용기', 4),
('극복', 4),
('해소', 4),

-- 대인관계 감정 (5)
('고립감', 5),
('연결감', 5),
('서운함', 5),
('이해받음', 5),
('부담감', 5);


# ========================== 감정 테이블



CREATE TABLE `emotion_analysis` (
                                    `id`	BIGINT	NOT NULL	PRIMARY KEY AUTO_INCREMENT,
                                    `evidence`	TEXT	NOT NULL,
                                    `reason`	TEXT	NOT NULL,
                                    `count`	INT	NOT NULL,
                                    `analysis_id`	BIGINT	NOT NULL,
                                    `emotion_id`	BIGINT	NOT NULL,
                                    FOREIGN KEY(`analysis_id`) REFERENCES `analysis`(`id`),
                                    FOREIGN KEY(`emotion_id`) REFERENCES `emotion`(`id`)
);

INSERT INTO `emotion_analysis` (`evidence`, `reason`, `count`, `analysis_id`, `emotion_id`)
VALUES
    (
        '내담자는 직장에서 상사와의 반복적인 갈등으로 인해 극심한 정서적 스트레스를 호소하고 있음. 수면장애와 식욕저하 등 신체적 증상까지 나타나며, 외부와 감정을 나누지 않고 혼자 감내하는 경향이 있음. 상담자는 내담자의 감정을 수용하며, 감정 표현과 스트레스 관리의 중요성을 강조함. 전반적으로 심리적 피로도가 높은 상태로 보이며, 중장기적 상담 개입과 더불어 구체적인 스트레스 해소 방안이 요구됨.',
        '직장 내 대인관계 및 감정 억제',
        1,
        1,  -- analysis_id
        7   -- emotion_id (무기력)
    ),
    (
        '잠도 자꾸 깨고 식욕도 없어요. 배가 고픈데 먹고 싶지가 않아요.',
        '신체적 피로와 의욕 저하가 지속되고 있으며, 일상 활동 유지가 어려움.',
        2,
        2,
        11 -- 무기력 (부정적 감정 카테고리)
    ),
    (
        '그냥 집에만 있고 싶고 사람 만나는 것도 피하게 돼요.',
        '사회적 접촉을 회피하며 고립감을 표현함.',
        1,
        3,
        26 -- 고립감 (대인관계 감정 카테고리)
    );
;
# ========================== 분석 감정별 정보 테이블



CREATE TABLE `shortened_counsel` (
                                     `id`	BIGINT	NOT NULL	PRIMARY KEY AUTO_INCREMENT,
                                     `emotional_change`	TEXT	NOT NULL,
                                     `cognitive`	TEXT	NOT NULL,
                                     `behavioral`	TEXT	NOT NULL,
                                     `response`	TEXT	NOT NULL,
                                     `recommended_direction`	TEXT	NOT NULL,
                                     `analysis_id`	BIGINT	NOT NULL,
                                     FOREIGN KEY(`analysis_id`) REFERENCES `analysis`(`id`)
);

INSERT INTO `shortened_counsel` (
    `emotional_change`,
    `cognitive`,
    `behavioral`,
    `response`,
    `recommended_direction`,
    `analysis_id`
) VALUES
      (
          '내담자는 직장에서의 스트레스와 상사와의 갈등으로 인한 감정적 피로와 불안감을 호소하고 있습니다. 수면 장애와 식욕 저하 등의 신체적 증상도 나타나며, 이는 내담자의 정서적 부담이 얼마나 큰지를 보여줍니다.',
          '내담자는 자신이 감정을 표현하는데 어려움을 겪고 있으며, 스트레스를 혼자서 감내하려는 경향이 강합니다. 이러한 인식이 내담자에게 더 큰 심리적 부담을 주고 있습니다.',
          '내담자는 일상적으로 상사와의 갈등을 피하려고 하며, 감정을 억제하고 표현하지 않으려 합니다. 상담 중에도 감정을 제대로 표현하기 어렵다는 모습을 보였습니다.',
          '내담자는 자신이 겪고 있는 갈등과 스트레스에 대해 이야기하면서 점차적으로 감정을 조금씩 표현하기 시작했습니다. 그러나 여전히 감정을 억제하려는 경향이 강한 모습을 보였습니다.',
          '내담자는 감정을 표현하는 데 있어 조금 더 개방적이고, 자신의 감정을 외부와 나누는 연습을 해야 합니다. 스트레스 해소를 위한 구체적인 방법(예: 운동, 취미 활동)을 함께 찾고, 직장에서의 감정 표현 방법을 연습하는 것이 필요합니다.',
          1  -- analysis_id
      ),
      (
          '내담자는 최근 수개월간의 무기력감과 의욕 저하를 호소하며, 사회적 관계에서도 고립되고 있습니다. 상담 도중 감정을 이야기하며 눈물을 흘리는 장면은 내면의 정서가 억눌려 있었음을 보여줍니다.',
          '내담자는 현재 자신이 처한 상황에 대해 명확한 이유를 설명하기 어려워하며, 삶에 대한 흥미나 기대가 현저히 낮아진 상태입니다. 이는 우울의 초기 또는 중등 수준의 징후로 볼 수 있습니다.',
          '혼자 있는 것을 선호하며 사회적 활동을 거의 하지 않고, 수면과 식사에도 문제가 발생하고 있습니다. 일상적인 기능 수행이 전반적으로 저하된 모습입니다.',
          '상담자는 내담자의 감정을 존중하고, 이야기할 수 있는 공간을 제공하며 내담자의 눈물을 자연스럽게 받아들였습니다. 이는 내담자가 처음으로 자신의 감정을 드러낼 수 있는 안전한 환경을 마련해주었습니다.',
          '내담자가 자신의 감정을 인식하고 받아들일 수 있도록 도우며, 일상 활동을 점진적으로 회복할 수 있도록 작은 목표를 함께 설정하고 실천할 필요가 있습니다.',
          2
      ),

-- 가족 간 진로 갈등 및 의사소통 단절 (analysis_id = 3)
      (
          '내담자는 가족 특히 부모님과의 갈등 속에서 외로움과 답답함을 느끼며 정서적으로 고립되어 있었습니다. 상담 중 공감받고 이해받는 경험을 통해 점차 마음의 안정감을 찾아가는 모습이 관찰되었습니다.',
          '내담자는 자신의 진로에 대한 생각과 부모님의 기대 사이의 간극에서 오는 혼란과 불안을 겪고 있으며, 자신이 이해받지 못하고 있다는 인식이 강하게 자리 잡고 있습니다.',
          '내담자는 가족과의 갈등 이후 대화를 피하고 있으며, 가족과의 관계에서 정서적 거리감을 유지하려는 경향을 보이고 있습니다. 또한 이러한 상황을 친구들에게조차 쉽게 공유하지 않는 모습입니다.',
          '상담자는 내담자가 감정을 자유롭게 표현할 수 있도록 지지적 태도를 보이며, 부담 없는 대화의 분위기를 만들어 주었습니다. 이를 통해 내담자는 상담 속에서 일시적으로라도 마음의 안정을 찾았습니다.',
          '가족과의 소통에서 감정 표현과 경청의 기술을 함께 연습하며, 갈등 상황에서도 자신의 입장을 건강하게 전달할 수 있는 방법을 찾아가는 과정이 필요합니다.',
          3
      );

# ========================== 상담 요약 테이블



CREATE database koala_crm;


use koala_crm;


CREATE table coupon_template (
	id bigint(20) not null auto_increment,
	coupon_name varchar(32),
	receieve_start datetime,
	receieve_end datetime,
	gmt_create datetime DEFAULT CURRENT_TIMESTAMP,
	gmt_update datetime ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY key (id)
);



CREATE table coupon_code (
	id bigint(20) not null auto_increment,
	coupon_code varchar(32),
	coupon_id BIGINT(20),
	validity_start datetime,
	validity_end datetime,
	gmt_create datetime DEFAULT CURRENT_TIMESTAMP,
	gmt_update datetime ON UPDATE CURRENT_TIMESTAMP,
	PRIMARY key (id)
);

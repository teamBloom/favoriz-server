CREATE TABLE "friend" (
    "id" int8 NOT NULL,
    "following" int8 NOT NULL,
    CONSTRAINT "friend_id_fkey" FOREIGN KEY ("id") REFERENCES "public"."user"("id"),
    CONSTRAINT "friend_follower_fkey" FOREIGN KEY ("following") REFERENCES "public"."user"("id"),
    PRIMARY KEY ("id","following")
);
CREATE SEQUENCE IF NOT EXISTS event_id_seq;

CREATE TABLE "public"."event" (
    "id" int8 NOT NULL DEFAULT nextval('event_id_seq'::regclass),
    "name" varchar(50),
    "date" timestamp,
    "type" varchar(50),
    "user_id" int8 NOT NULL,
    PRIMARY KEY ("id")
);

CREATE SEQUENCE IF NOT EXISTS user_id_seq;

CREATE TABLE "public"."user" (
    "id" int4 NOT NULL DEFAULT nextval('user_id_seq'::regclass),
    "name" varchar(50) NOT NULL,
    "thumbnail" varchar(2000) NULL,
    PRIMARY KEY ("id")
);

CREATE SEQUENCE IF NOT EXISTS wish_list_id_seq;

CREATE TABLE "public"."wish_list" (
    "id" int8 NOT NULL DEFAULT nextval('wish_list_id_seq'::regclass),
    "name" varchar(50) NOT NULL,
    "user_id" int8 NOT NULL,
    PRIMARY KEY ("id"),
    CONSTRAINT UK_USER_ID UNIQUE ("user_id")
);

CREATE TABLE "public"."wish_list_product_link" (
    "wish_list_id" int8 NOT NULL,
    "product_id" int8 NOT NULL,
    PRIMARY KEY ("wish_list_id", "product_id")
);

CREATE SEQUENCE IF NOT EXISTS product_id_seq;

CREATE TABLE "public"."product" (
    "id" int8 NOT NULL DEFAULT nextval('product_id_seq'::regclass),
    "name" varchar(50) NOT NULL,
    "price" int8 NOT NULL,
    PRIMARY KEY ("id")
);
CREATE TABLE districts
(
    id        bigserial  not null
        constraint district_pk
            primary key,
    city_id   text       not null,
    region_id text,
    language  varchar(3) not null,
    name text not null
);

create index district_city_id_index
    on districts (city_id);

create index district_region_id_index
    on districts (city_id);

create index district_language_index
    on districts (language);

create index districts_asc_index on districts (language asc, name asc);

INSERT INTO districts(language, city_id, name)
VALUES ('TR', '1', 'Aladağ'),
       ('TR', '1', 'Ceyhan'),
       ('TR', '1', 'Çukurova'),
       ('TR', '1', 'Feke'),
       ('TR', '1', 'Imamoğlu'),
       ('TR', '1', 'Karaisalı'),
       ('TR', '1', 'Karataş'),
       ('TR', '1', 'Kozan'),
       ('TR', '1', 'Pozantı'),
       ('TR', '1', 'Saimbeyli'),
       ('TR', '1', 'Sarıçam'),
       ('TR', '1', 'Seyhan'),
       ('TR', '1', 'Tufanbeyli'),
       ('TR', '1', 'Yumurtalık'),
       ('TR', '1', 'Yüreğir'),
       ('TR', '2', 'Besni'),
       ('TR', '2', 'Çelikhan'),
       ('TR', '2', 'Gerger'),
       ('TR', '2', 'Gölbaşı'),
       ('TR', '2', 'Kahta'),
       ('TR', '2', 'Merkez'),
       ('TR', '2', 'Samsat'),
       ('TR', '2', 'Sincik'),
       ('TR', '2', 'Tut'),
       ('TR', '3', 'Başmakçı'),
       ('TR', '3', 'Bayat'),
       ('TR', '3', 'Bolvadin'),
       ('TR', '3', 'Çay'),
       ('TR', '3', 'Çobanlar'),
       ('TR', '3', 'Dazkırı'),
       ('TR', '3', 'Dinar'),
       ('TR', '3', 'Emirdağ'),
       ('TR', '3', 'Evciler'),
       ('TR', '3', 'Hocalar'),
       ('TR', '3', 'Ihsaniye'),
       ('TR', '3', 'Iscehisar'),
       ('TR', '3', 'Kızılören'),
       ('TR', '3', 'Merkez'),
       ('TR', '3', 'Sandıklı'),
       ('TR', '3', 'Sinanpaşa'),
       ('TR', '3', 'Sultandağı'),
       ('TR', '3', 'Şuhut'),
       ('TR', '4', 'Diyadin'),
       ('TR', '4', 'Doğubayazıt'),
       ('TR', '4', 'Eleşkirt'),
       ('TR', '4', 'Hamur'),
       ('TR', '4', 'Merkez'),
       ('TR', '4', 'Patnos'),
       ('TR', '4', 'Taşlıçay'),
       ('TR', '4', 'Tutak'),
       ('TR', '5', 'Ağaçören'),
       ('TR', '5', 'Eskil'),
       ('TR', '5', 'Gülağaç'),
       ('TR', '5', 'Güzelyurt'),
       ('TR', '5', 'Merkez'),
       ('TR', '5', 'Ortaköy'),
       ('TR', '5', 'Sarıyahşi'),
       ('TR', '5', 'Sultanhanı'),
       ('TR', '6', 'Göynücek'),
       ('TR', '6', 'Gümüşhacıköy'),
       ('TR', '6', 'Hamamözü'),
       ('TR', '6', 'Merkez'),
       ('TR', '6', 'Merzifon'),
       ('TR', '6', 'Suluova'),
       ('TR', '6', 'Taşova'),
       ('TR', '7', 'Akyurt'),
       ('TR', '7', 'Altındağ'),
       ('TR', '7', 'Ayaş'),
       ('TR', '7', 'Bala'),
       ('TR', '7', 'Beypazarı'),
       ('TR', '7', 'Çamlıdere'),
       ('TR', '7', 'Çankaya'),
       ('TR', '7', 'Çubuk'),
       ('TR', '7', 'Elmadağ'),
       ('TR', '7', 'Etimesgut'),
       ('TR', '7', 'Evren'),
       ('TR', '7', 'Gölbaşı'),
       ('TR', '7', 'Güdül'),
       ('TR', '7', 'Haymana'),
       ('TR', '7', 'Kahramankazan'),
       ('TR', '7', 'Kalecik'),
       ('TR', '7', 'Keçiören'),
       ('TR', '7', 'Kızılcahamam'),
       ('TR', '7', 'Mamak'),
       ('TR', '7', 'Nallıhan'),
       ('TR', '7', 'Polatlı'),
       ('TR', '7', 'Pursaklar'),
       ('TR', '7', 'Sincan'),
       ('TR', '7', 'Şereflikoçhisar'),
       ('TR', '7', 'Yenimahalle'),
       ('TR', '8', 'Akseki'),
       ('TR', '8', 'Aksu'),
       ('TR', '8', 'Alanya'),
       ('TR', '8', 'Demre'),
       ('TR', '8', 'Döşemealtı'),
       ('TR', '8', 'Elmalı'),
       ('TR', '8', 'Finike'),
       ('TR', '8', 'Gazipaşa'),
       ('TR', '8', 'Gündoğmuş'),
       ('TR', '8', 'Ibradı'),
       ('TR', '8', 'Kaş'),
       ('TR', '8', 'Kemer'),
       ('TR', '8', 'Kepez'),
       ('TR', '8', 'Konyaaltı'),
       ('TR', '8', 'Korkuteli'),
       ('TR', '8', 'Kumluca'),
       ('TR', '8', 'Manavgat'),
       ('TR', '8', 'Muratpaşa'),
       ('TR', '8', 'Serik'),
       ('TR', '9', 'Çıldır'),
       ('TR', '9', 'Damal'),
       ('TR', '9', 'Göle'),
       ('TR', '9', 'Hanak'),
       ('TR', '9', 'Merkez'),
       ('TR', '9', 'Posof'),
       ('TR', '10', 'Ardanuç'),
       ('TR', '10', 'Arhavi'),
       ('TR', '10', 'Borçka'),
       ('TR', '10', 'Hopa'),
       ('TR', '10', 'Kemalpaşa'),
       ('TR', '10', 'Merkez'),
       ('TR', '10', 'Murgul'),
       ('TR', '10', 'Şavşat'),
       ('TR', '10', 'Yusufeli'),
       ('TR', '11', 'Bozdoğan'),
       ('TR', '11', 'Buharkent'),
       ('TR', '11', 'Çine'),
       ('TR', '11', 'Didim'),
       ('TR', '11', 'Efeler'),
       ('TR', '11', 'Germencik'),
       ('TR', '11', 'Incirliova'),
       ('TR', '11', 'Karacasu'),
       ('TR', '11', 'Karpuzlu'),
       ('TR', '11', 'Koçarlı'),
       ('TR', '11', 'Köşk'),
       ('TR', '11', 'Kuşadası'),
       ('TR', '11', 'Kuyucak'),
       ('TR', '11', 'Nazilli'),
       ('TR', '11', 'Söke'),
       ('TR', '11', 'Sultanhisar'),
       ('TR', '11', 'Yenipazar'),
       ('TR', '12', 'Altıeylül'),
       ('TR', '12', 'Ayvalık'),
       ('TR', '12', 'Balya'),
       ('TR', '12', 'Bandırma'),
       ('TR', '12', 'Bigadiç'),
       ('TR', '12', 'Burhaniye'),
       ('TR', '12', 'Dursunbey'),
       ('TR', '12', 'Edremit'),
       ('TR', '12', 'Erdek'),
       ('TR', '12', 'Gömeç'),
       ('TR', '12', 'Gönen'),
       ('TR', '12', 'Havran'),
       ('TR', '12', 'Ivrindi'),
       ('TR', '12', 'Karesi'),
       ('TR', '12', 'Kepsut'),
       ('TR', '12', 'Manyas'),
       ('TR', '12', 'Marmara'),
       ('TR', '12', 'Savaştepe'),
       ('TR', '12', 'Sındırgı'),
       ('TR', '12', 'Susurluk'),
       ('TR', '13', 'Amasra'),
       ('TR', '13', 'Kurucaşile'),
       ('TR', '13', 'Merkez'),
       ('TR', '13', 'Ulus'),
       ('TR', '14', 'Beşiri'),
       ('TR', '14', 'Gercüş'),
       ('TR', '14', 'Hasankeyf'),
       ('TR', '14', 'Kozluk'),
       ('TR', '14', 'Merkez'),
       ('TR', '14', 'Sason'),
       ('TR', '15', 'Aydıntepe'),
       ('TR', '15', 'Demirözü'),
       ('TR', '15', 'Merkez'),
       ('TR', '16', 'Bozüyük'),
       ('TR', '16', 'Gölpazarı'),
       ('TR', '16', 'Inhisar'),
       ('TR', '16', 'Merkez'),
       ('TR', '16', 'Osmaneli'),
       ('TR', '16', 'Pazaryeri'),
       ('TR', '16', 'Söğüt'),
       ('TR', '16', 'Yenipazar'),
       ('TR', '17', 'Adaklı'),
       ('TR', '17', 'Genç'),
       ('TR', '17', 'Karlıova'),
       ('TR', '17', 'Kiğı'),
       ('TR', '17', 'Merkez'),
       ('TR', '17', 'Solhan'),
       ('TR', '17', 'Yayladere'),
       ('TR', '17', 'Yedisu'),
       ('TR', '18', 'Adilcevaz'),
       ('TR', '18', 'Ahlat'),
       ('TR', '18', 'Güroymak'),
       ('TR', '18', 'Hizan'),
       ('TR', '18', 'Merkez'),
       ('TR', '18', 'Mutki'),
       ('TR', '18', 'Tatvan'),
       ('TR', '19', 'Dörtdivan'),
       ('TR', '19', 'Gerede'),
       ('TR', '19', 'Göynük'),
       ('TR', '19', 'Kıbrıscık'),
       ('TR', '19', 'Mengen'),
       ('TR', '19', 'Merkez'),
       ('TR', '19', 'Mudurnu'),
       ('TR', '19', 'Seben'),
       ('TR', '19', 'Yeniçağa'),
       ('TR', '20', 'Ağlasun'),
       ('TR', '20', 'Altınyayla'),
       ('TR', '20', 'Bucak'),
       ('TR', '20', 'Çavdır'),
       ('TR', '20', 'Çeltikçi'),
       ('TR', '20', 'Gölhisar'),
       ('TR', '20', 'Karamanlı'),
       ('TR', '20', 'Kemer'),
       ('TR', '20', 'Merkez'),
       ('TR', '20', 'Tefenni'),
       ('TR', '20', 'Yeşilova'),
       ('TR', '21', 'Büyükorhan'),
       ('TR', '21', 'Gemlik'),
       ('TR', '21', 'Gürsu'),
       ('TR', '21', 'Harmancık'),
       ('TR', '21', 'Inegöl'),
       ('TR', '21', 'Iznik'),
       ('TR', '21', 'Karacabey'),
       ('TR', '21', 'Keles'),
       ('TR', '21', 'Kestel'),
       ('TR', '21', 'Mudanya'),
       ('TR', '21', 'Mustafakemalpaşa'),
       ('TR', '21', 'Nilüfer'),
       ('TR', '21', 'Orhaneli'),
       ('TR', '21', 'Orhangazi'),
       ('TR', '21', 'Osmangazi'),
       ('TR', '21', 'Yenişehir'),
       ('TR', '21', 'Yıldırım'),
       ('TR', '22', 'Ayvacık'),
       ('TR', '22', 'Bayramiç'),
       ('TR', '22', 'Biga'),
       ('TR', '22', 'Bozcaada'),
       ('TR', '22', 'Çan'),
       ('TR', '22', 'Eceabat'),
       ('TR', '22', 'Ezine'),
       ('TR', '22', 'Gelibolu'),
       ('TR', '22', 'Gökçeada'),
       ('TR', '22', 'Lapseki'),
       ('TR', '22', 'Merkez'),
       ('TR', '22', 'Yenice'),
       ('TR', '23', 'Atkaracalar'),
       ('TR', '23', 'Bayramören'),
       ('TR', '23', 'Çerkeş'),
       ('TR', '23', 'Eldivan'),
       ('TR', '23', 'Ilgaz');
INSERT INTO districts(language, city_id, name)
VALUES ('TR', '23', 'Kızılırmak'),
       ('TR', '23', 'Korgun'),
       ('TR', '23', 'Kurşunlu'),
       ('TR', '23', 'Merkez'),
       ('TR', '23', 'Orta'),
       ('TR', '23', 'Şabanözü'),
       ('TR', '23', 'Yapraklı'),
       ('TR', '24', 'Alaca'),
       ('TR', '24', 'Bayat'),
       ('TR', '24', 'Boğazkale'),
       ('TR', '24', 'Dodurga'),
       ('TR', '24', 'Iskilip'),
       ('TR', '24', 'Kargı'),
       ('TR', '24', 'Laçin'),
       ('TR', '24', 'Mecitözü'),
       ('TR', '24', 'Merkez'),
       ('TR', '24', 'Oğuzlar'),
       ('TR', '24', 'Ortaköy'),
       ('TR', '24', 'Osmancık'),
       ('TR', '24', 'Sungurlu'),
       ('TR', '24', 'Uğurludağ'),
       ('TR', '25', 'Acıpayam'),
       ('TR', '25', 'Babadağ'),
       ('TR', '25', 'Baklan'),
       ('TR', '25', 'Bekilli'),
       ('TR', '25', 'Beyağaç'),
       ('TR', '25', 'Bozkurt'),
       ('TR', '25', 'Buldan'),
       ('TR', '25', 'Çal'),
       ('TR', '25', 'Çameli'),
       ('TR', '25', 'Çardak'),
       ('TR', '25', 'Çivril'),
       ('TR', '25', 'Güney'),
       ('TR', '25', 'Honaz'),
       ('TR', '25', 'Kale'),
       ('TR', '25', 'Merkezefendi'),
       ('TR', '25', 'Pamukkale'),
       ('TR', '25', 'Sarayköy'),
       ('TR', '25', 'Serinhisar'),
       ('TR', '25', 'Tavas'),
       ('TR', '26', 'Bağlar'),
       ('TR', '26', 'Bismil'),
       ('TR', '26', 'Çermik'),
       ('TR', '26', 'Çınar'),
       ('TR', '26', 'Çüngüş'),
       ('TR', '26', 'Dicle'),
       ('TR', '26', 'Eğil'),
       ('TR', '26', 'Ergani'),
       ('TR', '26', 'Hani'),
       ('TR', '26', 'Hazro'),
       ('TR', '26', 'Kayapınar'),
       ('TR', '26', 'Kocaköy'),
       ('TR', '26', 'Kulp'),
       ('TR', '26', 'Lice'),
       ('TR', '26', 'Silvan'),
       ('TR', '26', 'Sur'),
       ('TR', '26', 'Yenişehir'),
       ('TR', '27', 'Akçakoca'),
       ('TR', '27', 'Cumayeri'),
       ('TR', '27', 'Çilimli'),
       ('TR', '27', 'Gölyaka'),
       ('TR', '27', 'Gümüşova'),
       ('TR', '27', 'Kaynaşlı'),
       ('TR', '27', 'Merkez'),
       ('TR', '27', 'Yığılca'),
       ('TR', '28', 'Enez'),
       ('TR', '28', 'Havsa'),
       ('TR', '28', 'Ipsala'),
       ('TR', '28', 'Keşan'),
       ('TR', '28', 'Lalapaşa'),
       ('TR', '28', 'Meriç'),
       ('TR', '28', 'Merkez'),
       ('TR', '28', 'Süloğlu'),
       ('TR', '28', 'Uzunköprü'),
       ('TR', '29', 'Ağın'),
       ('TR', '29', 'Alacakaya'),
       ('TR', '29', 'Arıcak'),
       ('TR', '29', 'Baskil'),
       ('TR', '29', 'Karakoçan'),
       ('TR', '29', 'Keban'),
       ('TR', '29', 'Kovancılar'),
       ('TR', '29', 'Maden'),
       ('TR', '29', 'Merkez'),
       ('TR', '29', 'Palu'),
       ('TR', '29', 'Sivrice'),
       ('TR', '30', 'Çayırlı'),
       ('TR', '30', 'Iliç'),
       ('TR', '30', 'Kemah'),
       ('TR', '30', 'Kemaliye'),
       ('TR', '30', 'Merkez'),
       ('TR', '30', 'Otlukbeli'),
       ('TR', '30', 'Refahiye'),
       ('TR', '30', 'Tercan'),
       ('TR', '30', 'Üzümlü'),
       ('TR', '31', 'Aşkale'),
       ('TR', '31', 'Aziziye'),
       ('TR', '31', 'Çat'),
       ('TR', '31', 'Hınıs'),
       ('TR', '31', 'Horasan'),
       ('TR', '31', 'Ispir'),
       ('TR', '31', 'Karaçoban'),
       ('TR', '31', 'Karayazı'),
       ('TR', '31', 'Köprüköy'),
       ('TR', '31', 'Narman'),
       ('TR', '31', 'Oltu'),
       ('TR', '31', 'Olur'),
       ('TR', '31', 'Palandöken'),
       ('TR', '31', 'Pasinler'),
       ('TR', '31', 'Pazaryolu'),
       ('TR', '31', 'Şenkaya'),
       ('TR', '31', 'Tekman'),
       ('TR', '31', 'Tortum'),
       ('TR', '31', 'Uzundere'),
       ('TR', '31', 'Yakutiye'),
       ('TR', '32', 'Alpu'),
       ('TR', '32', 'Beylikova'),
       ('TR', '32', 'Çifteler'),
       ('TR', '32', 'Günyüzü'),
       ('TR', '32', 'Han'),
       ('TR', '32', 'Inönü'),
       ('TR', '32', 'Mahmudiye'),
       ('TR', '32', 'Mihalgazi'),
       ('TR', '32', 'Mihalıççık'),
       ('TR', '32', 'Odunpazarı'),
       ('TR', '32', 'Sarıcakaya'),
       ('TR', '32', 'Seyitgazi'),
       ('TR', '32', 'Sivrihisar'),
       ('TR', '32', 'Tepebaşı'),
       ('TR', '33', 'Araban'),
       ('TR', '33', 'Islahiye'),
       ('TR', '33', 'Karkamış'),
       ('TR', '33', 'Nizip'),
       ('TR', '33', 'Nurdağı'),
       ('TR', '33', 'Oğuzeli'),
       ('TR', '33', 'Şahinbey'),
       ('TR', '33', 'Şehitkamil'),
       ('TR', '33', 'Yavuzeli'),
       ('TR', '34', 'Alucra'),
       ('TR', '34', 'Bulancak'),
       ('TR', '34', 'Çamoluk'),
       ('TR', '34', 'Çanakçı'),
       ('TR', '34', 'Dereli'),
       ('TR', '34', 'Doğankent'),
       ('TR', '34', 'Espiye'),
       ('TR', '34', 'Eynesil'),
       ('TR', '34', 'Görele'),
       ('TR', '34', 'Güce'),
       ('TR', '34', 'Keşap'),
       ('TR', '34', 'Merkez'),
       ('TR', '34', 'Piraziz'),
       ('TR', '34', 'Şebinkarahisar'),
       ('TR', '34', 'Tirebolu'),
       ('TR', '34', 'Yağlıdere'),
       ('TR', '35', 'Kelkit'),
       ('TR', '35', 'Köse'),
       ('TR', '35', 'Kürtün'),
       ('TR', '35', 'Merkez'),
       ('TR', '35', 'Şiran'),
       ('TR', '35', 'Torul'),
       ('TR', '36', 'Çukurca'),
       ('TR', '36', 'Derecik'),
       ('TR', '36', 'Merkez'),
       ('TR', '36', 'Şemdinli'),
       ('TR', '36', 'Yüksekova'),
       ('TR', '37', 'Altınözü'),
       ('TR', '37', 'Antakya'),
       ('TR', '37', 'Arsuz'),
       ('TR', '37', 'Belen'),
       ('TR', '37', 'Defne'),
       ('TR', '37', 'Dörtyol'),
       ('TR', '37', 'Erzin'),
       ('TR', '37', 'Hassa'),
       ('TR', '37', 'Iskenderun'),
       ('TR', '37', 'Kırıkhan'),
       ('TR', '37', 'Kumlu'),
       ('TR', '37', 'Payas'),
       ('TR', '37', 'Reyhanlı'),
       ('TR', '37', 'Samandağ'),
       ('TR', '37', 'Yayladağı'),
       ('TR', '38', 'Aralık'),
       ('TR', '38', 'Karakoyunlu'),
       ('TR', '38', 'Merkez'),
       ('TR', '38', 'Tuzluca'),
       ('TR', '39', 'Aksu'),
       ('TR', '39', 'Atabey'),
       ('TR', '39', 'Eğirdir'),
       ('TR', '39', 'Gelendost'),
       ('TR', '39', 'Gönen'),
       ('TR', '39', 'Keçiborlu'),
       ('TR', '39', 'Merkez'),
       ('TR', '39', 'Senirkent'),
       ('TR', '39', 'Sütçüler'),
       ('TR', '39', 'Şarkikaraağaç'),
       ('TR', '39', 'Uluborlu'),
       ('TR', '39', 'Yalvaç'),
       ('TR', '39', 'Yenişarbademli'),
       ('TR', '40', 'Adalar'),
       ('TR', '40', 'Arnavutköy'),
       ('TR', '40', 'Ataşehir'),
       ('TR', '40', 'Avcılar'),
       ('TR', '40', 'Bağcılar'),
       ('TR', '40', 'Bahçelievler'),
       ('TR', '40', 'Bakırköy'),
       ('TR', '40', 'Başakşehir'),
       ('TR', '40', 'Bayrampaşa'),
       ('TR', '40', 'Beşiktaş'),
       ('TR', '40', 'Beykoz'),
       ('TR', '40', 'Beylikdüzü'),
       ('TR', '40', 'Beyoğlu'),
       ('TR', '40', 'Büyükçekmece'),
       ('TR', '40', 'Çatalca'),
       ('TR', '40', 'Çekmeköy'),
       ('TR', '40', 'Esenler'),
       ('TR', '40', 'Esenyurt'),
       ('TR', '40', 'Eyüpsultan'),
       ('TR', '40', 'Fatih'),
       ('TR', '40', 'Gaziosmanpaşa'),
       ('TR', '40', 'Güngören'),
       ('TR', '40', 'Kadıköy'),
       ('TR', '40', 'Kağıthane'),
       ('TR', '40', 'Kartal'),
       ('TR', '40', 'Küçükçekmece'),
       ('TR', '40', 'Maltepe'),
       ('TR', '40', 'Pendik'),
       ('TR', '40', 'Sancaktepe'),
       ('TR', '40', 'Sarıyer'),
       ('TR', '40', 'Silivri'),
       ('TR', '40', 'Sultanbeyli'),
       ('TR', '40', 'Sultangazi'),
       ('TR', '40', 'Şile'),
       ('TR', '40', 'Şişli'),
       ('TR', '40', 'Tuzla'),
       ('TR', '40', 'Ümraniye'),
       ('TR', '40', 'Üsküdar'),
       ('TR', '40', 'Zeytinburnu'),
       ('TR', '41', 'Aliağa'),
       ('TR', '41', 'Balçova'),
       ('TR', '41', 'Bayındır'),
       ('TR', '41', 'Bayraklı'),
       ('TR', '41', 'Bergama'),
       ('TR', '41', 'Beydağ'),
       ('TR', '41', 'Bornova'),
       ('TR', '41', 'Buca'),
       ('TR', '41', 'Çeşme'),
       ('TR', '41', 'Çiğli'),
       ('TR', '41', 'Dikili'),
       ('TR', '41', 'Foça'),
       ('TR', '41', 'Gaziemir'),
       ('TR', '41', 'Güzelbahçe'),
       ('TR', '41', 'Karabağlar');
INSERT INTO districts(language, city_id, name)
VALUES ('TR', '41', 'Karaburun'),
       ('TR', '41', 'Karşıyaka'),
       ('TR', '41', 'Kemalpaşa'),
       ('TR', '41', 'Kınık'),
       ('TR', '41', 'Kiraz'),
       ('TR', '41', 'Konak'),
       ('TR', '41', 'Menderes'),
       ('TR', '41', 'Menemen'),
       ('TR', '41', 'Narlıdere'),
       ('TR', '41', 'Ödemiş'),
       ('TR', '41', 'Seferihisar'),
       ('TR', '41', 'Selçuk'),
       ('TR', '41', 'Tire'),
       ('TR', '41', 'Torbalı'),
       ('TR', '41', 'Urla'),
       ('TR', '42', 'Afşin'),
       ('TR', '42', 'Andırın'),
       ('TR', '42', 'Çağlayancerit'),
       ('TR', '42', 'Dulkadiroğlu'),
       ('TR', '42', 'Ekinözü'),
       ('TR', '42', 'Elbistan'),
       ('TR', '42', 'Göksun'),
       ('TR', '42', 'Nurhak'),
       ('TR', '42', 'Onikişubat'),
       ('TR', '42', 'Pazarcık'),
       ('TR', '42', 'Türkoğlu'),
       ('TR', '43', 'Eflani'),
       ('TR', '43', 'Eskipazar'),
       ('TR', '43', 'Merkez'),
       ('TR', '43', 'Ovacık'),
       ('TR', '43', 'Safranbolu'),
       ('TR', '43', 'Yenice'),
       ('TR', '44', 'Ayrancı'),
       ('TR', '44', 'Başyayla'),
       ('TR', '44', 'Ermenek'),
       ('TR', '44', 'Kazımkarabekir'),
       ('TR', '44', 'Merkez'),
       ('TR', '44', 'Sarıveliler'),
       ('TR', '45', 'Akyaka'),
       ('TR', '45', 'Arpaçay'),
       ('TR', '45', 'Digor'),
       ('TR', '45', 'Kağızman'),
       ('TR', '45', 'Merkez'),
       ('TR', '45', 'Sarıkamış'),
       ('TR', '45', 'Selim'),
       ('TR', '45', 'Susuz'),
       ('TR', '46', 'Abana'),
       ('TR', '46', 'Ağlı'),
       ('TR', '46', 'Araç'),
       ('TR', '46', 'Azdavay'),
       ('TR', '46', 'Bozkurt'),
       ('TR', '46', 'Cide'),
       ('TR', '46', 'Çatalzeytin'),
       ('TR', '46', 'Daday'),
       ('TR', '46', 'Devrekani'),
       ('TR', '46', 'Doğanyurt'),
       ('TR', '46', 'Hanönü'),
       ('TR', '46', 'Ihsangazi'),
       ('TR', '46', 'Inebolu'),
       ('TR', '46', 'Küre'),
       ('TR', '46', 'Merkez'),
       ('TR', '46', 'Pınarbaşı'),
       ('TR', '46', 'Seydiler'),
       ('TR', '46', 'Şenpazar'),
       ('TR', '46', 'Taşköprü'),
       ('TR', '46', 'Tosya'),
       ('TR', '47', 'Akkışla'),
       ('TR', '47', 'Bünyan'),
       ('TR', '47', 'Develi'),
       ('TR', '47', 'Felahiye'),
       ('TR', '47', 'Hacılar'),
       ('TR', '47', 'Incesu'),
       ('TR', '47', 'Kocasinan'),
       ('TR', '47', 'Melikgazi'),
       ('TR', '47', 'Özvatan'),
       ('TR', '47', 'Pınarbaşı'),
       ('TR', '47', 'Sarıoğlan'),
       ('TR', '47', 'Sarız'),
       ('TR', '47', 'Talas'),
       ('TR', '47', 'Tomarza'),
       ('TR', '47', 'Yahyalı'),
       ('TR', '47', 'Yeşilhisar'),
       ('TR', '48', 'Bahşılı'),
       ('TR', '48', 'Balışeyh'),
       ('TR', '48', 'Çelebi'),
       ('TR', '48', 'Delice'),
       ('TR', '48', 'Karakeçili'),
       ('TR', '48', 'Keskin'),
       ('TR', '48', 'Merkez'),
       ('TR', '48', 'Sulakyurt'),
       ('TR', '48', 'Yahşihan'),
       ('TR', '49', 'Babaeski'),
       ('TR', '49', 'Demirköy'),
       ('TR', '49', 'Kofçaz'),
       ('TR', '49', 'Lüleburgaz'),
       ('TR', '49', 'Merkez'),
       ('TR', '49', 'Pehlivanköy'),
       ('TR', '49', 'Pınarhisar'),
       ('TR', '49', 'Vize'),
       ('TR', '50', 'Akçakent'),
       ('TR', '50', 'Akpınar'),
       ('TR', '50', 'Boztepe'),
       ('TR', '50', 'Çiçekdağı'),
       ('TR', '50', 'Kaman'),
       ('TR', '50', 'Merkez'),
       ('TR', '50', 'Mucur'),
       ('TR', '51', 'Elbeyli'),
       ('TR', '51', 'Merkez'),
       ('TR', '51', 'Musabeyli'),
       ('TR', '51', 'Polateli'),
       ('TR', '52', 'Başiskele'),
       ('TR', '52', 'Çayırova'),
       ('TR', '52', 'Darıca'),
       ('TR', '52', 'Derince'),
       ('TR', '52', 'Dilovası'),
       ('TR', '52', 'Gebze'),
       ('TR', '52', 'Gölcük'),
       ('TR', '52', 'Izmit'),
       ('TR', '52', 'Kandıra'),
       ('TR', '52', 'Karamürsel'),
       ('TR', '52', 'Kartepe'),
       ('TR', '52', 'Körfez'),
       ('TR', '53', 'Ahırlı'),
       ('TR', '53', 'Akören'),
       ('TR', '53', 'Akşehir'),
       ('TR', '53', 'Altınekin'),
       ('TR', '53', 'Beyşehir'),
       ('TR', '53', 'Bozkır'),
       ('TR', '53', 'Cihanbeyli'),
       ('TR', '53', 'Çeltik'),
       ('TR', '53', 'Çumra'),
       ('TR', '53', 'Derbent'),
       ('TR', '53', 'Derebucak'),
       ('TR', '53', 'Doğanhisar'),
       ('TR', '53', 'Emirgazi'),
       ('TR', '53', 'Ereğli'),
       ('TR', '53', 'Güneysınır'),
       ('TR', '53', 'Hadim'),
       ('TR', '53', 'Halkapınar'),
       ('TR', '53', 'Hüyük'),
       ('TR', '53', 'Ilgın'),
       ('TR', '53', 'Kadınhanı'),
       ('TR', '53', 'Karapınar'),
       ('TR', '53', 'Karatay'),
       ('TR', '53', 'Kulu'),
       ('TR', '53', 'Meram'),
       ('TR', '53', 'Sarayönü'),
       ('TR', '53', 'Selçuklu'),
       ('TR', '53', 'Seydişehir'),
       ('TR', '53', 'Taşkent'),
       ('TR', '53', 'Tuzlukçu'),
       ('TR', '53', 'Yalıhüyük'),
       ('TR', '53', 'Yunak'),
       ('TR', '54', 'Altıntaş'),
       ('TR', '54', 'Aslanapa'),
       ('TR', '54', 'Çavdarhisar'),
       ('TR', '54', 'Domaniç'),
       ('TR', '54', 'Dumlupınar'),
       ('TR', '54', 'Emet'),
       ('TR', '54', 'Gediz'),
       ('TR', '54', 'Hisarcık'),
       ('TR', '54', 'Merkez'),
       ('TR', '54', 'Pazarlar'),
       ('TR', '54', 'Simav'),
       ('TR', '54', 'Şaphane'),
       ('TR', '54', 'Tavşanlı'),
       ('TR', '55', 'Akçadağ'),
       ('TR', '55', 'Arapgir'),
       ('TR', '55', 'Arguvan'),
       ('TR', '55', 'Battalgazi'),
       ('TR', '55', 'Darende'),
       ('TR', '55', 'Doğanşehir'),
       ('TR', '55', 'Doğanyol'),
       ('TR', '55', 'Hekimhan'),
       ('TR', '55', 'Kale'),
       ('TR', '55', 'Kuluncak'),
       ('TR', '55', 'Pütürge'),
       ('TR', '55', 'Yazıhan'),
       ('TR', '55', 'Yeşilyurt'),
       ('TR', '56', 'Ahmetli'),
       ('TR', '56', 'Akhisar'),
       ('TR', '56', 'Alaşehir'),
       ('TR', '56', 'Demirci'),
       ('TR', '56', 'Gölmarmara'),
       ('TR', '56', 'Gördes'),
       ('TR', '56', 'Kırkağaç'),
       ('TR', '56', 'Köprübaşı'),
       ('TR', '56', 'Kula'),
       ('TR', '56', 'Salihli'),
       ('TR', '56', 'Sarıgöl'),
       ('TR', '56', 'Saruhanlı'),
       ('TR', '56', 'Selendi'),
       ('TR', '56', 'Soma'),
       ('TR', '56', 'Şehzadeler'),
       ('TR', '56', 'Turgutlu'),
       ('TR', '56', 'Yunusemre'),
       ('TR', '57', 'Artuklu'),
       ('TR', '57', 'Dargeçit'),
       ('TR', '57', 'Derik'),
       ('TR', '57', 'Kızıltepe'),
       ('TR', '57', 'Mazıdağı'),
       ('TR', '57', 'Midyat'),
       ('TR', '57', 'Nusaybin'),
       ('TR', '57', 'Ömerli'),
       ('TR', '57', 'Savur'),
       ('TR', '57', 'Yeşilli'),
       ('TR', '58', 'Akdeniz'),
       ('TR', '58', 'Anamur'),
       ('TR', '58', 'Aydıncık'),
       ('TR', '58', 'Bozyazı'),
       ('TR', '58', 'Çamlıyayla'),
       ('TR', '58', 'Erdemli'),
       ('TR', '58', 'Gülnar'),
       ('TR', '58', 'Mezitli'),
       ('TR', '58', 'Mut'),
       ('TR', '58', 'Silifke'),
       ('TR', '58', 'Tarsus'),
       ('TR', '58', 'Toroslar'),
       ('TR', '58', 'Yenişehir'),
       ('TR', '59', 'Bodrum'),
       ('TR', '59', 'Dalaman'),
       ('TR', '59', 'Datça'),
       ('TR', '59', 'Fethiye'),
       ('TR', '59', 'Kavaklıdere'),
       ('TR', '59', 'Köyceğiz'),
       ('TR', '59', 'Marmaris'),
       ('TR', '59', 'Menteşe'),
       ('TR', '59', 'Milas'),
       ('TR', '59', 'Ortaca'),
       ('TR', '59', 'Seydikemer'),
       ('TR', '59', 'Ula'),
       ('TR', '59', 'Yatağan'),
       ('TR', '60', 'Bulanık'),
       ('TR', '60', 'Hasköy'),
       ('TR', '60', 'Korkut'),
       ('TR', '60', 'Malazgirt'),
       ('TR', '60', 'Merkez'),
       ('TR', '60', 'Varto'),
       ('TR', '61', 'Acıgöl'),
       ('TR', '61', 'Avanos'),
       ('TR', '61', 'Derinkuyu'),
       ('TR', '61', 'Gülşehir'),
       ('TR', '61', 'Hacıbektaş'),
       ('TR', '61', 'Kozaklı'),
       ('TR', '61', 'Merkez'),
       ('TR', '61', 'Ürgüp'),
       ('TR', '62', 'Altunhisar'),
       ('TR', '62', 'Bor'),
       ('TR', '62', 'Çamardı'),
       ('TR', '62', 'Çiftlik');
INSERT INTO districts(language, city_id, name)
VALUES ('TR', '62', 'Merkez'),
       ('TR', '62', 'Ulukışla'),
       ('TR', '63', 'Akkuş'),
       ('TR', '63', 'Altınordu'),
       ('TR', '63', 'Aybastı'),
       ('TR', '63', 'Çamaş'),
       ('TR', '63', 'Çatalpınar'),
       ('TR', '63', 'Çaybaşı'),
       ('TR', '63', 'Fatsa'),
       ('TR', '63', 'Gölköy'),
       ('TR', '63', 'Gülyalı'),
       ('TR', '63', 'Gürgentepe'),
       ('TR', '63', 'Ikizce'),
       ('TR', '63', 'Kabadüz'),
       ('TR', '63', 'Kabataş'),
       ('TR', '63', 'Korgan'),
       ('TR', '63', 'Kumru'),
       ('TR', '63', 'Mesudiye'),
       ('TR', '63', 'Perşembe'),
       ('TR', '63', 'Ulubey'),
       ('TR', '63', 'Ünye'),
       ('TR', '64', 'Bahçe'),
       ('TR', '64', 'Düziçi'),
       ('TR', '64', 'Hasanbeyli'),
       ('TR', '64', 'Kadirli'),
       ('TR', '64', 'Merkez'),
       ('TR', '64', 'Sumbas'),
       ('TR', '64', 'Toprakkale'),
       ('TR', '65', 'Ardeşen'),
       ('TR', '65', 'Çamlıhemşin'),
       ('TR', '65', 'Çayeli'),
       ('TR', '65', 'Derepazarı'),
       ('TR', '65', 'Fındıklı'),
       ('TR', '65', 'Güneysu'),
       ('TR', '65', 'Hemşin'),
       ('TR', '65', 'Ikizdere'),
       ('TR', '65', 'Iyidere'),
       ('TR', '65', 'Kalkandere'),
       ('TR', '65', 'Merkez'),
       ('TR', '65', 'Pazar'),
       ('TR', '66', 'Adapazarı'),
       ('TR', '66', 'Akyazı'),
       ('TR', '66', 'Arifiye'),
       ('TR', '66', 'Erenler'),
       ('TR', '66', 'Ferizli'),
       ('TR', '66', 'Geyve'),
       ('TR', '66', 'Hendek'),
       ('TR', '66', 'Karapürçek'),
       ('TR', '66', 'Karasu'),
       ('TR', '66', 'Kaynarca'),
       ('TR', '66', 'Kocaali'),
       ('TR', '66', 'Pamukova'),
       ('TR', '66', 'Sapanca'),
       ('TR', '66', 'Serdivan'),
       ('TR', '66', 'Söğütlü'),
       ('TR', '66', 'Taraklı'),
       ('TR', '67', '19 MAYIS'),
       ('TR', '67', 'Alaçam'),
       ('TR', '67', 'Asarcık'),
       ('TR', '67', 'Atakum'),
       ('TR', '67', 'Ayvacık'),
       ('TR', '67', 'Bafra'),
       ('TR', '67', 'Canik'),
       ('TR', '67', 'Çarşamba'),
       ('TR', '67', 'Havza'),
       ('TR', '67', 'Ilkadım'),
       ('TR', '67', 'Kavak'),
       ('TR', '67', 'Ladik'),
       ('TR', '67', 'Salıpazarı'),
       ('TR', '67', 'Tekkeköy'),
       ('TR', '67', 'Terme'),
       ('TR', '67', 'Vezirköprü'),
       ('TR', '67', 'Yakakent'),
       ('TR', '68', 'Baykan'),
       ('TR', '68', 'Eruh'),
       ('TR', '68', 'Kurtalan'),
       ('TR', '68', 'Merkez'),
       ('TR', '68', 'Pervari'),
       ('TR', '68', 'Şirvan'),
       ('TR', '68', 'Tillo'),
       ('TR', '69', 'Ayancık'),
       ('TR', '69', 'Boyabat'),
       ('TR', '69', 'Dikmen'),
       ('TR', '69', 'Durağan'),
       ('TR', '69', 'Erfelek'),
       ('TR', '69', 'Gerze'),
       ('TR', '69', 'Merkez'),
       ('TR', '69', 'Saraydüzü'),
       ('TR', '69', 'Türkeli'),
       ('TR', '70', 'Akıncılar'),
       ('TR', '70', 'Altınyayla'),
       ('TR', '70', 'Divriği'),
       ('TR', '70', 'Doğanşar'),
       ('TR', '70', 'Gemerek'),
       ('TR', '70', 'Gölova'),
       ('TR', '70', 'Gürün'),
       ('TR', '70', 'Hafik'),
       ('TR', '70', 'Imranlı'),
       ('TR', '70', 'Kangal'),
       ('TR', '70', 'Koyulhisar'),
       ('TR', '70', 'Merkez'),
       ('TR', '70', 'Suşehri'),
       ('TR', '70', 'Şarkışla'),
       ('TR', '70', 'Ulaş'),
       ('TR', '70', 'Yıldızeli'),
       ('TR', '70', 'Zara'),
       ('TR', '71', 'Akçakale'),
       ('TR', '71', 'Birecik'),
       ('TR', '71', 'Bozova'),
       ('TR', '71', 'Ceylanpınar'),
       ('TR', '71', 'Eyyübiye'),
       ('TR', '71', 'Halfeti'),
       ('TR', '71', 'Haliliye'),
       ('TR', '71', 'Harran'),
       ('TR', '71', 'Hilvan'),
       ('TR', '71', 'Karaköprü'),
       ('TR', '71', 'Siverek'),
       ('TR', '71', 'Suruç'),
       ('TR', '71', 'Viranşehir'),
       ('TR', '72', 'Beytüşşebap'),
       ('TR', '72', 'Cizre'),
       ('TR', '72', 'Güçlükonak'),
       ('TR', '72', 'Idil'),
       ('TR', '72', 'Merkez'),
       ('TR', '72', 'Silopi'),
       ('TR', '72', 'Uludere'),
       ('TR', '73', 'Çerkezköy'),
       ('TR', '73', 'Çorlu'),
       ('TR', '73', 'Ergene'),
       ('TR', '73', 'Hayrabolu'),
       ('TR', '73', 'Kapaklı'),
       ('TR', '73', 'Malkara'),
       ('TR', '73', 'Marmaraereğlisi'),
       ('TR', '73', 'Muratlı'),
       ('TR', '73', 'Saray'),
       ('TR', '73', 'Süleymanpaşa'),
       ('TR', '73', 'Şarköy'),
       ('TR', '74', 'Almus'),
       ('TR', '74', 'Artova'),
       ('TR', '74', 'Başçiftlik'),
       ('TR', '74', 'Erbaa'),
       ('TR', '74', 'Merkez'),
       ('TR', '74', 'Niksar'),
       ('TR', '74', 'Pazar'),
       ('TR', '74', 'Reşadiye'),
       ('TR', '74', 'Sulusaray'),
       ('TR', '74', 'Turhal'),
       ('TR', '74', 'Yeşilyurt'),
       ('TR', '74', 'Zile'),
       ('TR', '75', 'Akçaabat'),
       ('TR', '75', 'Araklı'),
       ('TR', '75', 'Arsin'),
       ('TR', '75', 'Beşikdüzü'),
       ('TR', '75', 'Çarşıbaşı'),
       ('TR', '75', 'Çaykara'),
       ('TR', '75', 'Dernekpazarı'),
       ('TR', '75', 'Düzköy'),
       ('TR', '75', 'Hayrat'),
       ('TR', '75', 'Köprübaşı'),
       ('TR', '75', 'Maçka'),
       ('TR', '75', 'Of'),
       ('TR', '75', 'Ortahisar'),
       ('TR', '75', 'Sürmene'),
       ('TR', '75', 'Şalpazarı'),
       ('TR', '75', 'Tonya'),
       ('TR', '75', 'Vakfıkebir'),
       ('TR', '75', 'Yomra'),
       ('TR', '76', 'Çemişgezek'),
       ('TR', '76', 'Hozat'),
       ('TR', '76', 'Mazgirt'),
       ('TR', '76', 'Merkez'),
       ('TR', '76', 'Nazımiye'),
       ('TR', '76', 'Ovacık'),
       ('TR', '76', 'Pertek'),
       ('TR', '76', 'Pülümür'),
       ('TR', '77', 'Banaz'),
       ('TR', '77', 'Eşme'),
       ('TR', '77', 'Karahallı'),
       ('TR', '77', 'Merkez'),
       ('TR', '77', 'Sivaslı'),
       ('TR', '77', 'Ulubey'),
       ('TR', '78', 'Bahçesaray'),
       ('TR', '78', 'Başkale'),
       ('TR', '78', 'Çaldıran'),
       ('TR', '78', 'Çatak'),
       ('TR', '78', 'Edremit'),
       ('TR', '78', 'Erciş'),
       ('TR', '78', 'Gevaş'),
       ('TR', '78', 'Gürpınar'),
       ('TR', '78', 'Ipekyolu'),
       ('TR', '78', 'Muradiye'),
       ('TR', '78', 'Özalp'),
       ('TR', '78', 'Saray'),
       ('TR', '78', 'Tuşba'),
       ('TR', '79', 'Altınova'),
       ('TR', '79', 'Armutlu'),
       ('TR', '79', 'Çınarcık'),
       ('TR', '79', 'Çiftlikköy'),
       ('TR', '79', 'Merkez'),
       ('TR', '79', 'Termal'),
       ('TR', '80', 'Akdağmadeni'),
       ('TR', '80', 'Aydıncık'),
       ('TR', '80', 'Boğazlıyan'),
       ('TR', '80', 'Çandır'),
       ('TR', '80', 'Çayıralan'),
       ('TR', '80', 'Çekerek'),
       ('TR', '80', 'Kadışehri'),
       ('TR', '80', 'Merkez'),
       ('TR', '80', 'Saraykent'),
       ('TR', '80', 'Sarıkaya'),
       ('TR', '80', 'Sorgun'),
       ('TR', '80', 'Şefaatli'),
       ('TR', '80', 'Yenifakılı'),
       ('TR', '80', 'Yerköy'),
       ('TR', '81', 'Alaplı'),
       ('TR', '81', 'Çaycuma'),
       ('TR', '81', 'Devrek'),
       ('TR', '81', 'Ereğli'),
       ('TR', '81', 'Gökçebey'),
       ('TR', '81', 'Kilimli'),
       ('TR', '81', 'Kozlu'),
       ('TR', '81', 'Merkez');
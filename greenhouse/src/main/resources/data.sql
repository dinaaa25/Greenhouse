-- SEED SCRIPT
DELETE FROM area;
DELETE FROM greenhouse;
DELETE FROM crop;
DELETE FROM polygon;
-- ADD greenhouses

INSERT INTO greenhouse (id, description, name) VALUES (1, 'A greenhouse specializing in crisp lettuce varieties grown hydroponically in California.', 'HydroLettuce Oasis');
INSERT INTO greenhouse (id, description, name) VALUES (2, 'An organic greenhouse cultivating vibrant bell peppers in the sunny fields of Spain.', 'Pepper Patch Greenhouse');
INSERT INTO greenhouse (id, description, name) VALUES (3, 'A greenhouse dedicated to the cultivation of aromatic herbs like basil and mint in Italy.', 'Herb Haven Greenhouse');
INSERT INTO greenhouse (id, description, name) VALUES (4, 'A greenhouse nestled in the countryside of France, producing a variety of colorful carrots.', 'French Carrot Fields');
INSERT INTO greenhouse (id, description, name) VALUES (5, 'An urban greenhouse in New York City specializing in microgreens and sprouts.', 'CitySprout Urban Farm');
INSERT INTO greenhouse (id, description, name) VALUES (6, 'A greenhouse in the Netherlands renowned for its vibrant tulip displays.', 'Tulip Terrace Greenhouse');
INSERT INTO greenhouse (id, description, name) VALUES (7, 'A greenhouse in Japan dedicated to the art of bonsai cultivation.', 'Bonsai Haven Greenhouse');
INSERT INTO greenhouse (id, description, name) VALUES (8, 'A greenhouse in the mountains of Switzerland growing a variety of alpine flowers.', 'Alpine Bloom Garden');
INSERT INTO greenhouse (id, description, name) VALUES (9, 'A greenhouse on the coast of Australia specializing in exotic orchids.', 'Orchid Oasis Greenhouse');
INSERT INTO greenhouse (id, description, name) VALUES (10, 'A greenhouse in Brazil focused on the cultivation of tropical fruits like mangoes and papayas.', 'Tropical Fruit Paradise');


-- ADD crops
INSERT INTO crop (id, description, max_temp, min_temp, name, image) VALUES (1, 'Solanum lycopersicum is the scientific name of the tomato plant. It belongs to the nightshade family, Solanaceae. Tomatoes require a maximum temperature of 30°C and a minimum temperature of 15°C for optimal growth.', 30, 15, 'Tomato', 'https://pngimg.com/uploads/tomato/tomato_PNG12519.png');
INSERT INTO crop (id, description, max_temp, min_temp, name, image) VALUES (2, 'Oryza sativa is the scientific name of rice. It is one of the most important cereal crops in the world. Rice plants thrive in temperatures ranging from 20°C to 35°C, with a minimum temperature requirement of 15°C.', 35, 20, 'Rice', 'https://www.creativefabrica.com/wp-content/uploads/2021/12/16/Rice-Plant-PNG-File-Cute-Clip-Art-Graphics-21813742-1-580x387.png');
INSERT INTO crop (id, description, max_temp, min_temp, name, image) VALUES (3, 'Brassica oleracea var. capitata is the scientific name of cabbage. It belongs to the Brassicaceae family. Cabbage plants prefer cool temperatures and grow best when the maximum temperature is around 20°C and the minimum temperature is around 10°C.', 20, 10, 'Cabbage', 'https://i.pinimg.com/originals/80/9c/69/809c690c5283d654e6c8092b9fd7f1ca.png');
INSERT INTO crop (id, description, max_temp, min_temp, name, image) VALUES (4, 'Capsicum annuum is the scientific name of bell pepper. It is a member of the nightshade family, Solanaceae. Bell peppers thrive in warm temperatures, with a maximum temperature requirement of 30°C and a minimum temperature requirement of 15°C.', 30, 15, 'Bell Pepper', 'https://static.vecteezy.com/system/resources/previews/029/720/456/original/bell-pepper-transparent-background-png.png');
INSERT INTO crop (id, description, max_temp, min_temp, name, image) VALUES (5, 'Triticum aestivum is the scientific name of wheat. Wheat is a staple food crop worldwide. It grows best in temperatures ranging from 15°C to 24°C, with a minimum temperature requirement of 5°C.', 24, 15, 'Wheat', 'https://pngimg.com/d/wheat_PNG81.png');
INSERT INTO crop (id, description, max_temp, min_temp, name, image) VALUES (6, 'Mentha spicata is the scientific name of spearmint. It is a perennial herb used in culinary and medicinal applications. Spearmint thrives in temperatures ranging from 18°C to 25°C, with a minimum temperature requirement of 10°C.', 25, 18, 'Spearmint', 'https://static.vecteezy.com/system/resources/previews/022/804/962/original/mint-leaves-mint-leaves-isolated-on-transparent-background-png.png');
INSERT INTO crop (id, description, max_temp, min_temp, name, image) VALUES (7, 'Lycopersicon esculentum is the scientific name of cherry tomato. It is a smaller, sweeter variety of tomato. Cherry tomatoes prefer warmer temperatures, with a maximum temperature requirement of 35°C and a minimum temperature requirement of 15°C.', 35, 15, 'Cherry Tomato', 'https://static.vecteezy.com/system/resources/previews/021/938/593/original/vegetables-cherry-tomatoes-isolated-on-a-transparent-background-png.png');
INSERT INTO crop (id,description, max_temp, min_temp, name, image) VALUES (8, 'Citrus limon is the scientific name of lemon. Lemons are citrus fruits known for their sour taste and high vitamin C content. Lemon trees thrive in temperatures ranging from 25°C to 30°C, with a minimum temperature requirement of 10°C.', 30, 25, 'Lemon', 'https://pngimg.com/uploads/lemon/lemon_PNG25198.png');
INSERT INTO crop (id, description, max_temp, min_temp, name, image) VALUES (9, 'Fragaria ananassa is the scientific name of strawberry. Strawberries are perennial plants grown for their sweet, juicy fruit. They prefer temperatures between 15°C and 25°C, with a minimum temperature requirement of 5°C.', 25, 15, 'Strawberry', 'https://static.vecteezy.com/system/resources/previews/041/321/303/non_2x/ai-generated-watercolor-painting-of-strawberry-free-png.png');
INSERT INTO crop (id, description, max_temp, min_temp, name, image) VALUES (10, 'Cucumis sativus is the scientific name of cucumber. Cucumbers are vining plants grown for their refreshing fruits. They require warm temperatures, with a maximum temperature of 32°C and a minimum temperature of 18°C for optimal growth.', 32, 18, 'Cucumber', 'https://images.rawpixel.com/image_png_800/czNmcy1wcml2YXRlL3Jhd3BpeGVsX2ltYWdlcy93ZWJzaXRlX2NvbnRlbnQvbHIvcGQyMC00NS00OS1wbG95XzIucG5n.png');

-- Add Areas
INSERT INTO area (id, crop_id, greenhouse_id, polygon_id) VALUES (1, 1, 1, null);
INSERT INTO area (id, crop_id, greenhouse_id, polygon_id) VALUES (2, 2, 2, null);
INSERT INTO area (id, crop_id, greenhouse_id, polygon_id) VALUES (3, 3, 3, null);
INSERT INTO area (id, crop_id, greenhouse_id, polygon_id) VALUES (4, 4, 4, null);
INSERT INTO area (id, crop_id, greenhouse_id, polygon_id) VALUES (5, 5, 5, null);
INSERT INTO area (id, crop_id, greenhouse_id, polygon_id) VALUES (6, 6, 6, null);
INSERT INTO area (id, crop_id, greenhouse_id, polygon_id) VALUES (7, 7, 7, null);
INSERT INTO area (id, crop_id, greenhouse_id, polygon_id) VALUES (8, 8, 8, null);
INSERT INTO area (id, crop_id, greenhouse_id, polygon_id) VALUES (9, 9, 9, null);
INSERT INTO area (id, crop_id, greenhouse_id, polygon_id) VALUES (10, 10, 10, null);


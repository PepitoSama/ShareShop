USE `ShareShop`;
--
-- Contenu de la table `Group`
--

INSERT INTO `Group` (`idGroup`, `name`) VALUES
(14, ''),
(6, 'abc'),
(9, 'coucou'),
(4, 'dqesefs'),
(10, 'ekjfklez'),
(13, 'Groupe2'),
(8, 'mon groupe'),
(7, 'Mon Joli Group'),
(12, 'MonGroupe'),
(5, 'qzdezqdees'),
(1, 'Test'),
(2, 'test2'),
(3, 'test3');

--
-- Contenu de la table `GroupList`
--

INSERT INTO `GroupList` (`idGroupList`, `idGroup`, `name`, `date`, `type`) VALUES
(1, 1, 'My List Beautifull', '2019-12-26', 'S'),
(2, 1, 'First List', '2019-12-26', 'S'),
(3, 1, 'Test', '2019-12-30', 'S'),
(5, 1, 'Quatre', '2019-12-30', 'S'),
(12, 9, 'My listeve', '2020-01-10', 'S'),
(13, 9, 'toto', '2020-01-10', 'S'),
(19, 12, 'Maliste', '2020-01-11', 'S'),
(20, 12, 'Maliste2', '2020-01-11', 'S');

--
-- Contenu de la table `Image`
--

INSERT INTO `Image` (`idImage`, `image`) VALUES
(1, 0x89504e470d0a1a0a0000000d49484452000002000000020008040000005e711c710000000467414d410000b18f0bfc6105000000206348524d00007a26000080840000fa00000080e8000075300000ea6000003a98000017709cba513c00000002624b47440000aa8d2332000000097048597300000bb800000bb80049b528810000000774494d4507e008080e202885fb735e0000414e4944415478daed9d799c55c599bf9f7b7bdf371abaa1f76e36d90401d184a8c8a2286e896bd4688c899a4c348999389399df642699642666d12cc68c468dc67d47404401511065911d597b017a6f687a5f6edf7b7f7fd02a204b77579d5be79cfb3ee7839f18b975ebad7bea5b6f55bdf5160882200882200882200882200882200882200882200882200882200882200882e0403ca62b2018208ac10c259b34e288258a1e3ae8a0856a0e5083cf74f584d02102105e44308c898ca790610c259d58e27a05a09d16aad9cf3eb6b09e5282a6ab2a84021180f0c1cb70e632953114137fd2bfe5a3942d7ccc42369baeb02008bac8e47bbc410dc13e3d8d2ce61e724d575a10041d4ce129f613e863f70f12244015cf73315ed35517044185486e67255dfde8fc9f3eddace59f48306d8020080325817f636fbfc6fea39f1ecaf86f324d1b2108c24048e101aa07dcfd8304f153cb83649936441084fe92cc03d42b75ff23ab010d3cc860d3c60882d01f92f9bd86ee7f4402eaf91d834c1b2408425f49e6011ab474ff231250c72f49356d9420087d21965f52a7adfb1f91805a7e4a9c69c30441381d11dccb01adddff880494f36d224c1b2708c2a9f0721b7b3577fe4f25603b574b689020d89708ae649325ddffc8f31ee78b0408823df1328525da9dff63bd80e738430e91b90599d1b98b5ceee532222dfc060fc369630b6da64d15742002e02652b99d5b48b2f85b2229a6929d92384410ec442c37b1d342e7ffe8e703661065da60411df100dc420493b99ba921fab65c3c6ca6d1b4d1822a22006e6118dfe6ab96cefe8fa598037c429769b305418024becdfe10b9ff9f3e9b994db469c3054188e4023e0871f70f12e4598a6543d0d9c814c00de47117971a08cf29e400dbe8366dbe20843349dc4ead81f13f48906d4c0fe1ba832008c711c1545619eafe41023c2ea9429c8c44753b9d415cc71463dfeee10a661163ba1104213c89e31aaa8c8dff479e350c97a54041083d1e8a79c770f70fd2c32fc5071084d093c88f69372e0041aa98263e802084162f93d86dbcf31f795e94902041082dc93c82df78d73ff2b430cf747308423811c1451c36def13f7f3e922bc49c8844023a9514fec208d395388a41d4b2d6742504213cf0720fddc647fd639fbd0c33dd2c427f110fc09964f377524c57e23812f0b2c4742504211c78445be24f3f3ddacaaae24cd30d2308ee671a9dda1cf7c5fc8c0d9acaeae655092e17046b896695a6313bc0662ec7cbdddaee11aae3aba69b4710dccd4ddaa2ffaab99b6820890769d652a28fe5249a6e2041702fe97cac29fca78d07c9e82d75246fe2d3526a0ddf94b06041b0062f3fa245d358fdd631c788af63879669400f2b2443802058433e5bb48cff01f61c3752c7f05b4d9185d5fc932c050a827ea2f8a5a6b9fa617e4fea71a50fe76d2dc1453daca0c074530982fb98c8275adcf46e1633fe04e5df409996f2abb95732050a825ee2f893a6f97f19b79df01be2798c360de5fb799751a69b4b10dcc50c4d37ffb5f124834ef21de7b24dcb1a432d3f950c0182a08f149ed0343a6f61d649bfc5cb2fb578197e5630d1749309a747566b9dc24cbe44bc86729a59c4fb27fdaf011ee313fccadfe2e50c2e272e84ed23082e268be7e9d03032fb789fd1a7f9ae3bb4ec3404788f734c379b703ac4037006b3994cac86721a799a1da7f93b2fb25a830fe0612c9748962041502787e7b59cffebe41532fbf07d17d3a8c50758c1b9a69b4e3835e2013881394cd190793f481d7fa6be0f7f7339af1354fe3e0fe3982d3e8020a851c00b746918913b78a0cfd388f1d469f10196c93a80bd110fc0ee7898c3d91af6d48354f2173afbf8b7b7f2a496ba4f648696bd0b41085386f3a29683ba5dfc6bbfe4be98035a7c80259c6dba098593231e80bdf13083695ae2ea4b798c403ffe7e058f68a9ff54ce131f401006c6285ea447cb487c5bbfd37414b047cb372f36787db92038182f7768bafc7bdd001275c5f0232ddfddcc3d5a62180421cc18c3cb9ad27f5d31806ff790cf562d3ec02226996e4a41701a11dc498396eebf7880b3f0586ed7f2fdaddca9218e4110c28ab1bca2253d878f2f0f384d673e6bb548c0821326201104e124447287a61c7d7f5788c68be5eb5a26219d7c4b7c0041e83be378454bf73fcc44a5cdde02ded1528fd71963ba49852f227100f6249aa95ca0a19c207f634fbff6ff8fa78647e8d250930b39537204d90f11007b52c2c55fc8da3b10aa799236a5123a59c7320d3549e032f274348da01311003b12c31466682827c0dfa9501aff01aa785651448e308771e203d80d11003b52c025a46928a79c9768562ea583b5acd0509b14ae244b433982464400ec470c6771a186727a789232e5f11f601f2fd1a2a19cb98c214a433982364400ec471e5790aea19c5d2ca4494b8dda59cb4a0de56470e567d7910ab64004c06ec43249cbf8dfcd33946a19ff01ca98af454ce6314aee0cb213220076239babb48cff5b5942a3b65ab5b19ad51acac9e24a92b5d54a504604c05ec43089991acae9e405f6a09ed7ef73f6b090c31acab992e14468ac97a0840880bdc8e41a2de3ff06966be9ae9fd3c66a3ed2504e2e57498210fb20026027a299788a6bbbfa4e1bafb24bebf80fb093255a44e51a0ae4bdb30bf243d88934aed7b2ffbf9ef734adff1f4d2b2b59aba19c7cae948020bb2002601fa23893391aca6963213bb48fff00db59a641583cdc48b605b513068008807d48e4262df3fff5acd410ff77225a799f8d1aca29e60ad90cb4072200762182b15caca19c36de62ab25e33fc066ded51013e8e55b5aa63a82322200762196db348dffef6909db3d312dbcc7560de58ce472cbea28088ec3c3640e69c9bef7ef24595ad364eea74d434d37c842a01d100fc01e4472a716a7f863dea3d5d29a36b38c4f349433864b2cada7203888315af2ffb5f1f301e4ffef2f293ca4e5b2f2151211681ef100ecc1dda4682865034b2d1eff019a799bdd1aca99a425e98920389e7c5a358ca8edfc0f7121a96f0a8fd3ad5cdf1e160c385db9a009f100ecc00f1512777fce26dea22324f56d620965caa544708edc1c2c08b95ad6ff3bf85d0833efa7f082864b4bbb784a7c00b38807601a0f3fd2b271b78937b4a4efee1b4d2ca042b99468663221647516041b5248b596f5ff0742bcaf3e883734f8006dfc49f6024c221e8059bcdca121ff7f901d2ca03ba4356f6021d5caa5c4711123425a6fe1184400cc92cf5735ccdc3b58cbaa90d7fd0d76e1572cc3432637890f600e11009378b98d21cacb6041f6f25a88d6ff8fa692c51c522e2589b91486bcee422f22002629e4720de9b13a59c7fb46eaff2a7b35f800c3b85ade435348c39bc3cb8de428ff02412a7845cbd55dfd670f4b349c3c4ce3628619a9bf20026090422ed59022bb93f55a2eee1a182fb14ff9ee81084ab85ce201cc2002600a2fd752a8a1fdab79d1c2f3ffa7632bcb35ac3e6432579284994104c014455ca46103b093f52c376845907f50836afea1484633dba015618c088019bc5cc9080ddb5f0d3c6b51febfbeb281151a2210b3b9884ca37684292200662862b6866b32bb59cf32c396f8798246651f20863339dfb02561890880093ccc638c86bcb887f98705f9fffbcb1a562a6f06421eb32551a8101e94b0089f721c7d376f6a5845d0c12c9a349c67d8c85cd386841fe201841e0f17334ec3f8dfce539aefff1b28ab58ad3c098062e668c98b2408b6a698d7348cff3d2cb791cb7c99860c41413e942461a1463c80d0338b891ac6ff2e1ea5d1b4299fb18cf51a4a3983995a7223097d460420d4143183a1caa504d9ca02d3a61c452b0f6b282591732441486811010835173045c3f8efe7cf3658ff3f9af96c572ec3c3442e08616233410420c41430831c0de5ece435d3a61c47138f682825992f33d6b4298260153753aa61b12cc86da60d3901d99469b0ec10f7c8cdc1a1433c805092c70cf23494b397174d9b72020ef28486525299ce28d3a6088215dcc05e2de3ff776d29dc1e8aa9d3605d3db7d9d23e57220d1d3a7299a125f95505cf299fc1b78220b53ca9a19c0ccea7d8b43182a0170fd753a1617c0cf04f449936e6a4368ea551838d35dc2043536890660e15f9ccd436fff79936e62404a9e419d4838287308b02d3c684072200a12182b399a9a11c3f0fdb6cffff589a795a4bfde67096240b0f052200a1218f595ac6ff525ea5d3b431a7c0cf5e5ed7504e3633b5c44b08a7410420144431594bcaab1e1ea54e838b6d2587784e8b0f703113241ec07a440042410e1791aba19c3d2c309400bceff8d8ce5b1acac96516434c1be37e4400ac279a49ccd1504e0f4f5169f3f11fa09697b4e429bc84b1e203588d0880f50ce3522d175fec66b1c104e07da78b8dbca7a19c422e62906963dc8e0880d54433918b3494d3c3b394db3200e88b54f19a16a99ac768f101ac4504c06ab2b9922c0de5ece46d9b24003b3d6dac618d86728ab5dc9d209c0211006b89e56c4de3ffcbec71c8f80f50c11b5a962baf62a4c40358890880b50ce5eb5ae6b13b59aae12aeed0d1cc6a366828a798cb2451a895880058493cd3b94043393dbcce0e078dff00bb795343c892876b19253e807588005887876c6e254943493b58c641d3e6f493c3ac628b8672f2b8564b1b0a274404c03ae2b888b33594d3c302b66ab87b27b404d9ca620db7067ab89a71e203084ec3c370366a49ffb191d98eec001e66b15e4b0b3c2a3e805588076015b15ccd180de5f4f0261b1d37fe0304d9c03b746b28e90a26c89b2a38090fa3b4a4c80cb29e398e7df9bd5cc2062dadf02cb1a68d71274e7db5ec4e34dfd172fcd7c7dbac73d8faffe70458c30a7a3494740967e3316d8e20f40d0fe77050cbc8b7968b1c2dd25eae648b969678c391eb20425812c99b5a5efa2e7e6da30b400746267fa147435bb47389695304a16f7c9d2e2d02b086398e777c3d5cc3764dab21b20e2038806476691aff7fe38aedaf4c1ec7afa53dee326d8a209c9e9fe3d336febb010f376a91c40065649a3646104ecd584dcb7feddcef1a973793a735f900bf73fc94487035b1bca165fc0ff03ed34d1ba391af6b9a16d530c9b42982703222f921cd5a5ef4c3fcc255b970d2799a6e2d3ec08baef18b0497e1613a150434bce67e96bb6ea4bb969d5aa4b19e5b252240b023852cd532ca05a9e3a7ae9beba6f0349d5ac47113e34d1b2308c71247018fd2a2a5fbfb58c228d30659c055ecd0e21fb5f3b4640bd68538536a7848209b12cee7bb5ca669d7be96275860da300bd8cf444668b8d9388a2174b349cb39c3b0c74d0b4da12482045249631023388bb329d1b634e56303af9836cf125a798ea90cd730b919ccb7686125076874ec41299b2002d01f3c24904e06e964924f11258c6488e636ace515f69936d42296b39a1ce2359454cc2f59cf0a36b18f031cd272e2302c71db52931524924a1aa9a4924e36051452c8302daff117e96211dfa1deb4c99631938728d1f6d6056860331fb38b6a6aa9a3814eec7f759aad10013811512492422ae9a493ce10b2184a36590c26ced2ef0d52ce8f78d5b4f91612cb9fb85ebb7876504919a59451493535d4d1283e41df100138420489a492da3bd60f663019643284c10c212664b568e719eeb1fdfdbf6a9cc3638cb028c7418006f6534e25d534504f3d35d43be23e456384ab007849ea75eb5349238d149249279db4de7f461ba853809ddcca47a69bc66222f815779160f1b70438441db554514b1535bd1384431a6e2a7019e122001e927a5dfab45ec73e9954527a9f54e26d9077a795dff1f330705d47f1026342d6de41daa8efedfe0d34504f1d75d45347abec20b85700224824838cdece9e411a2924914c32c924914c920d3afcb1f859c30d949bae4608f0f023fed3a245d45313a09d461a394c238d34504b2df5d4514f7db8fa066e11000f896492461a8319cc20324823f1b3278978db6f78367327cf98ae4488c8e605ce352ec15d34d344f3674f1d75d4524725d5e123074e158048d218c420327b9f0c1248248e7812492481380d1167a1c4cf73dc45b3e96a848c2bf987111fe0e474d3460badb4d2c4611aa8a1861a6aa9a19e76d395b30ea708809764b218c2108690c5600691483c719ffd89333e9ea851c95c369bae440849e0ffb8c174254e4a902eda3e7b5a394835d55453453535b4bb29d6c0ae02e021862cb28ffa93421c71c4f6fe33c6e11dfe78eee50147defe3370c6b28274d395e81341bae9a083f6de3f0d54514565ef1f877b6d76128018b2c925973c72c96530b1c4104b4cef3fdd7c6c69259773c87425424c04ffc6cf4c576240f8e8fcece9a09103bd4f25951c76dace825901886230f9e4f5fe194a3cd1c4104b34310e9bc3abd0c65cde335d090364b39089a62ba14c0fdd74f5fee9e430fba8e87d0ed06affc942e805209241143182118ca08854a289268a68a288b4953f123a7ec5cfe9305d090378b998575d26f401baf1f5fee9a281fdec631f15ec61af86abd22d20345dce43062319c94846514c069144114524912e9bc90f84755c41a5e94a182285df73abe94a58881f3f3df4e0c74727fbd8c54e76b38b32fbec2b582b00833993b398cc18b2f012d1fb84e7387f629a99c7aa305bfefb1c0fa378937cd3d50809410204f0e3c74f3715ec62273bd849194d26aba5b7337af0e02185314c663293c925126fefff2b7c9120f7f257971ffe3935315cc593b60fd2d2cfd1798eabd8ce6636b399037401c1de3f214147c73c32b6c751cc14263399e1161f9a750b015ee6fbd498ae866106f173be2d5341000eb2832d6c6613bbe8c0dfeb31588a8a0078882686040a39977399c250f919fb4180757c93edf65f27b6180fa3798a89e2231e4327bbd9ca5636b099767cf8f059b3c138b0668f20817806338d0b38975cf9f1fa8d9f1d7c97556170f6eff444338bbf906bba1a36a583cdace763365143279d74e1d3597c7fbbae976452296016e771a6e5a7badd4a0f3bf96796da7363c800c9dcc07f32d874356c8d8f7d6c60239b28a385365ae9d6e13df6470092184c0e3398c35961b86ca38f6e36f35fbc1d3e27cefac0206ee38722017d20c041b6b19eb5ece110cd34ab79047d13800832c8e5cb5cc6b972339b222d7cc4fff0be64b53f8e2c6ee30e86c974b28f04a86113ebf9980a1a68a06360fec0e99b3b961c46703e9753ecea78fc5010a49637f9331bc376e7ff540ce2eb7c972279cbfa858fdd7cc46a76524555ff038c4e2d00711470169730930c5166653ad8c90b3ceddaacffeaa4710577305ebccc7e13a49cb5ac603be554f6675270f26e1d4709677311e79361da3a17d04335eff30cef8675d8cfe989e57c6ee33c06c980330082ece27d3ee4137672b06f1f3971334790c705cc63ba747e0d04a8671d8b594899e9aa38002fa3b88ecb1919c274eceea2938f59c6476c61ffe963074e2400494ce36a2e22475458991e0ef0312b59ca76d9f3ef33699ccf155cc050590f18203eca58c12a3e62cfa9df3bcf17fe3d9b2bb891b38c64c677137eaad8d5bb61b35b3a7f3ff150c80c2ee44b220203c64f2defb394f7d87bf2f7cf73dcbf15f12daea3c074dd1d4d0b65ec6207bbd8c59ebecec5842f104131d3389ba99c419c78a303c24f0dab58ca324a4f3c1d38ba59bd947037579369bad68e24c0412a28650fe51ca09c0afb9cf976301eb23983918c6502e348345d1d47e2a79295bccaf2130d46470b401ef7711d69a6ebeb288234b18f32caa9a08a3aaaa9a639ec0ff8e82682a11450c84846338a22591eec37ddec62114ff1c9f111289f0b403adfe51e87e469354d80660e5041297ba9a481060e72484f6cb670523ca4934516390c6704c32924c574951cc521dee361de3fd633fd5400e2b8825f9363ba8e3626c861f6b39f03eca3927a9a68a291c68186600a03269254324827930246328a910c91b3297da28b2dfc8685b47efe7f797aff59c23f986aba7eb6c3471d5554f626766ca09556da68a54d22f96d8097f8dedb9d87f57a0445648a149c92003bf815af7d2e01479a2b811b5d90a059071dd45249656f96f71ada7aaf8468a75db6f26c4680565a390044f75e0897c8200a29a198628a25a0f8047819c5ffa395c59f9e45f5005e26b0882cd37533829f4347ddf372807adae8faec9159bdd38820b6f7aab844f219411185e4932349ea8e22c8466efff4409a0788e3dfb92f6cf6590f53c9fede51fe0035b4f4265ceac6878f1ee9f2ae21baf78a9968e2194651ef934f5ad8bceb27a387c57c872a3822004358439ee93a59849f462a7bbbfc012a39400b3e7a7a1fbf74f8b0c0430451bd4f3499145344018514904b6c58ca41173fe271da8f34cdcd3cea9a749e015aa8a49c7dd47080322a68a2a737bbea91bcecd2e1c39dcf6fa888209ac114f48a4121a3c268dda09c0b2923e8218657b9d8746d068c9f5a2aa8605fef4a7d15ed047a33ae07083aedaa4621e478f0e0edfd13431ec514514c1145e4ba7ae520c8fdfc8c0e0fa9ecb7798865b0b74b0708e2e7201594534e39a5eca352126b0a16114d76af141453443e894749851baeba39c8042a3dcc61b1e99a7c017fef13c04f17b594534639651c603f87249d9660800832c8eb9d2a1452421a91447c369d70a61cdcc9a3915c60ba1600f8e9c1d7fba7930394514629a594512bfbef820df053471deb3efbf74cf229a0907cf2c9279dc8deeb6e9d74cbf54d3ce9613ef30c7dbd1f5fef6e7b3b3554f4baf665ecd77bf58120588c97540a7a9f428691443431bd7b0e51365e600f302e32c4f1ff7e3ae9a4830e3a38c801cad9c35e76724896eb04c712e01087f8b8f7df2248eb0d3fca25870292892596386289b6996fe0e53c0f350c094103b5d3422b2d3450412965945246a3cce605d7134fce671b8d3924124f3c71c4db24fee0390f1d16ee7db6d34c134d1ca2949dec6467ff52160b82ab88268f3cf2c9239fa1a490441249241265ac46151e0e5b70aaba837aeaa8671fbbd9c56eca64b34e108e21866114524821f90c26851452490eb95f10f45045b6b6e20234524915a56c6113db25378e209c964832c8279f02f2c822830c32c9202a3452e06113e3359413a4890a76b3990d6c15475f10068087647228a49862863284210c21d9daaf8ce4132d027098f9bcc4066a64614f10064890269ad80678c9a280428ac8279b6c8691698d4710c916aed5504e80723ea421b4ed25082e254015557c0024914f3e458c6438250cd39d103582486ed6a02df16450c16ed9cd1704ad7453c76ed6f2011bd9c40eea8924495fe2b3085ab841cb3e4006316ca7d6605309827be9a48aad7cc40636b19b0e5249d0506a30023f63395343515eb2e9e4135a0c379420b8971e1ad8c106602283349457efa58717341db749e57a2e25c968030982fb4964b4a61c9edb2208d2c40c8669292e851c76b34f760204c13262b982ef688ade790a2086bb3ecba2a3faf858c8045b44390b821bf1701e2be8d1d25bfd47ee02f150c43a4d0210a48dbfba36c5a820986634ffa043535fdd42f291bbd73bf071a9a6713b8a12826ca1cd744b0982ebc8e65bdca465fd1fe041de3df23f3c14b3529b0f10e4103f928b1b05413389dc4e8db65edac0f0cf07fd38bea1695e71e4a9e76657e75415845013c55c76695bad0bf2a7633d89221668148000b5cc3378ce5910dc4504e7f2317e8de3ffb863939545319726ad1250c9341be7431304e7e0612c2b3576ff20bff862c44e16bfd7e860040952ca28d9121404453c0ce71dad7db38c9127ea9953d9a25500826c0a71d25141701b1e0a98afb557f6f0c31347ec267217ad9a256029834db7a02038160f43794a739f5c45c9c9beae98c7e9d6fa65015ed714b72c08e14726bfd7dcfd0f73cdc913017b388f759a57027c3ca331efa020840f69fc97f6def8d0a94ffe247027b59a35a79347196aba2d05c161a4f013add13941826ce6dcd3edcd15f027ed2b01adfc51244010fa412a3fa04b733f3cc8f7fa12a37b368b34af040439ccfd9a0e1d0b82fb49e707b468f7c41fa1a82f5f1ec5556cd43cf708d2c02f450204a10fa4f1030e69ee7f015632fd78f73fe2845f1fa0122f6335e7248f6724b08356d3ad2b08b626836f701f199a83e8f6f120ef1c7f4757c449fe7217d5a43152f3bd810994e0638f4880209c940c6ee15e8668eefe8d3cc1331c3cfeff8e38e9079aa8612805446bad4612c3f1512a1220082724835bb887a19abb7f070b79883d5ffc0f11a7f8502d0d8c60d829ff4e7ff190c208fc944af66041f802197c83ef93abb9fbfbf980dfb38e13dcd479eace5d452b6768be94c8430a25f8d92b5e80201c4306dfe07be4693f43bb9d3ff036dd27fa4fa716003ffb08308654add5f19042b14880201c4326b7702705dabbff7e1ee5859379dca773efbb29279ad1dab2901dc143aa780182701499dcca1d146aeffe077996474e7e63d7e9e7f76dec2155fb7e80871486e3971d014100b2f816df215f7bf76f6301bfa354b598429ed01e1c1c24c03eee6388a1261704bb90cdbfb34f7be05d902ede62b21e5119c922ed71c94102ece79fc934ddfe8260901cfe8b4a0bba7f0f1f7181ae7b843d9cc987da4f26050952c98fb55c7328084e24975f516b41f70fb08d79c4e8aba897a9ecb0a0a2416ab98f0cd3bf83201820975f73d0823e15a08ceb35afdb11c1f9545b50d92007f97f220142d891c3fd1cb6a44755f32d2beee588e432da2da970333fd31c6d2008f626973f5ab0b41e244823f758752d4f24b76bcd4efef9d3c1ff6a3e7d2808f665187fa2d3929ed4c62f75cefd8f278afb2c590908e2e38f249afe5d042104e4f2b4254bea41ba79c8ea1bb962f857edf9823e7d1e3e71be7241700d5e8ab55ec377ec20faa4d6c37b272191ffd57647f9f1cf933211105c4c04a3596659f75f18aa2b79d3f8036d1699f198ec08082e2582097c6451bfe96629e9a133258bbf58b486d9c393728f80e0422298c2268bba7f17cbc90bad39793c46b345c63c4da15c2b2ab88a28bec44ecbbaff128a42df638a79427beae2234f27afc8cdc2828b8861a665ddbf93b718adfd24611ff07006cf5a24011dbcca04134609827612b8823d166d9f77b288f1a158fb3f115e26f292456b01edbcc154538609823652b899328bba7f070b9964b2977899ca4b16ad0574b088e95687350882a56470a725a7fd8f8cfe0b98a2ebc8ef40f13285172c9380b799696560a32058ca50ee65bf85ddff5c3b0c905ecee6798b24a093e55c1aaaf00641d04a01ff45b585ddffcb76e8fe7044025eb46839b08bf7b98278d3260a423f19c96fa9b5a44f04e9e00dbea2f9da1e25229866d944a08b555c2307850447318ebfd06059f79fcf7976eafe00114ce5058bbc001f6bb8514e09080ec1c3649eb024d74f90206dbcc274bb757ff87439d01a09e86103df94a4218203f0722ecf5b94eb27482b2f32cd2e73ff2f9a7e966571017eb6723b69a64d14845312c54cdeb068321ca485e79862d7ee0f4742835eb6e8a4a09f1ddc256705051b13cd5c965994382f480bcf30d1f4beffe9f03281d72dca1710602fdf1709106c4a1c57b1daa2545f419a7992b14e888df53286572d93807ddc2b1220d89004ae63a365d9b29a7992914e391de3a184172d53c21afe4d2440b01949dccc0e8b32fd0569e66f165c1d6a211e7279c132353cc8fd729f90602392f936151665cc0ed2c2a30c73daf1780f4378dec226f9b56c0a0a36218d1f536f51c86f9016fe44a6d3baff115279daa24609d2cec3a49836501048e3671645bf0409d2c6fd4ece959d60a104f8784cce08088649e3010b6ecefef4e9e03f9c7e1a368e872c5b1a09f08a93d551703c8378dc32d73f48073f75a6eb7f2c893c68d93d02415e93e840c1081e865a76c5479020cddc62da445d24f32bcb6649011632d40d3a29380a0f79bc6d59e70f50c78d6e7aabd3f905872c6aac1e16396b8f54703c118cb6ec8a8f2001cab9dc09317ffd219dfb2c4b8fd0cd5b9ce1b606136c4b1453f9d8b2b97f0f3bb8c4ce077e064a063fe68045cdd6c552ceb2fb3109c115c43083cd9645b8f858cf2c3b9ef6d74106dfa7d4320978d71e2912055713cf656cb7acfb77b192f3ddfc16a771073b2d6abe2e96db2f5192e02a92b9deb2f737481b8bf9929bbb3f401adf66ab4591015dbccb2ca7074e08b6259ddbd9636178fbcb4c0e87696c0ab7f0313e8b24600517136bda44c1850ce16ecb26b0411a799a89e1b2909dc40dacb54c02de65ae4880a0991cfe850acbba7f2d7f656ce8b7b24de94d37653490c7100b6a10c150f2a9633f3e43d609ee238fdbf80eb91685e654f10c7f6027c1509b65cee1e8a68c5a72c9b6440286914f3dfb4402042d14723bb7926351e9fbf93b7f65af09c34cce387c9453490ed9162c7b44904d3e75220182064ab8839b196651e9a53ccae3549836d20cd1cce46d8b0e0a75b38a2be5b8b0a0c8281ea0daa2997f801ddc43b669134d12c579bc69511ae56e568b04080a7818c3c3d459d4fdfd6ce636496d17c934165ae405f8f8482e1615068887f1165ef0d5c37aae959c5600114cb2ec26011f6bb9543605857ee361024f5b76c1978f0f9947826923ed829731bc62511a711f6bdd7bb842b08823375c5975c15737ef73810c4b47e3a1887f58945bcdc75ace737b84b5a0112f13986fd1057747ceac4c95f7f18b0ce3498ba2037dace3dc7088b21634e0618c65ab5241ba788bb1f22e9e984c1eb628d8b287759c29598384d3e261246f5a76ab5537f3257bd5a948e6218b9abe87758c72539635c1023c14b3d4b21bad7cfcdda9577c848e44fed7a2e6f7b38e7cd3e60936c6432ecb2c4c62ff6759f7ef0b09fcdca21f21c0faf08ebb124e81871c565976decfcf2fc2e5b0af3a09fcab658b301f926eda3cc196e45898e7b78d1f48f7ef0f89dc6d5910c61b729588701c1e86f28145ef5b8043dc219128fd2585bba9b3c421f3f198488070141ef2586151f7f773801b244ddd4048e1bb16a511efe0b772b9b8f019792cb468d5c9cf2eae9298bf8192c27728b524096313f7c9b5a20200793c6b590cea662e97eeaf4232dfb4280d7335b71167da3cc138b9fccda2e3e85d7c28096ad549e656b65be0a0f9d9c515b23413e664f3a045477eda79870be4fdd24132b7b0d90209f0b186f3252c338c19c47f506f49f76f61befbaff8081d49dccc460b24a093459c69da38c110a9dccd7e4bbaff619e67aaecfbeb24996fb0c182b3824d3c46b169e30403c4730bbb2cd9636ae4292639c3b3748e4675514a2385646a6ed8188611641b6da60d14424a3417f363465bd04d0ff21a0fb289806913dd47a245f709ede54e39a411567899c1724bb6feea78883172decf2a12b88e75da25c0cf475cec0c974dd0c259bc6c49be9f1a1e609469e3fa8373a60047f0514603c50cd6da5d3da413cf0eea4c9b27848442becbe5168481d5f0147f619769f3fa83d304e08804d4305af35a401459b4b3990ed3e6099693c6cd7c834cede556f3187fa5d4b479e1401c57b34d7b74e056ae926980eb89e63ab65ab0f65fc5bf5b7677a0f005e2b9865d9a25a08b2728316d986031d378cb8265e42afe992cd3a68517f15c4bb966253fc0ad12bbe56a86f26b5ab577ff5a7e20177c859e78aea34aab04f8799a91a6cd122cc3cb55ecd5defd1bb847b24b98218e1b38a4d907b856d6015ccb70feae3d9cfc30df97fbfdcc11c78d5a8f72fa79d0b27be005b344709df6833f6d7c8f44d3868537317c53eba2ce5aa69b3649b084221ed3bc66d4cd5d72f3b47962b957e30fdbc5ed7286db955c4495d6eeefe7bb92e9cf1e24f01b8d3fec5fc8336d90a09d0cfe43f382f1f765c7c83e24f3b8b6e59d0f39dbb439827626f09ec6eedfc5f7a4fbdb8b2c5ed7b416d0cce5729acb6578b954e3627107ffee96b9bf7bb6bc6ab997f7e9d1505212f97238d865a431595b02d8761ee28fb49b36490fee118020a5fc848d5ad23014936cda1c412be94cd654523bcf703f874d1b249c88682ea14c838bf732234c9b2268650aa55a9cff769ea5c0b4313a718f0700d0cd2afe40a3723983e5be0057114126b91acae9e26d7e4e85697374e22e0180c3bcca4b742996922e9739b88a58f289542ec5cf07fc373b089a3647276e1300a8e00936289611afe17511ec43ac96f0ee1dfcde7da93edd270041b6f0129d4a6544393053927072a219ac5c46157fe57d65dfd276b84f00a085529a954af0bbcbcd0b7b2295f3ffb5f332f3ddb8f6ef4601003f3ea5cffbf09b3641d08857794d673d2fb2cfb41956e04e01407104f7b96da62728f221dbdce915ba5300bc8a71da5de201b88aa0f2efd94cab6923acc19d0210a1b88adfa6388510ec86aa47d7ad25c8dc86b85300a214e77c4d749b3641d04840b9fb7adc7a3ccc8d02104182a200348b00b80abff2d5af5e1100e71047bae23e7e8b0880abf0d3a25842845b2343dc2800f1ca39da0fbb2fe023ace951168038b7a68973a700642896704804c055a80b40925b12801c8f1b0520418300a885120bf6a28726c51252dc9a22c68d02a03a0508d0286b00aea2473988375904c039c493aef4f916da2512d055f868548ce313017010aa1ec041b7e47b137a09d2a9f89bca14c0317849555c03a853de3516ec46b7e22a80088063486498e29e6d9d5be3bec3982e0e2a7d5ea6008e21911cc5121a640ae03abaa853fa7c2a49ee8c051401f822e201b88f2eea953e1fcd20774602b84f009214f3bf05a91501701d9d8a020083dd795784fb0440d503e8a456c2805c87aa07008395d38ad912b709809714c50490351c7667ee97b0a6931ac512c4037004710c553cb651ad1c362ad88f4e6a1493bc648a00388178f2144ba87663eed7b02740b3e246a078008e204159006ac40370256d542b7d3e8354d7f516dc2700898a573706a956bc5340b0276d54297d3e8a4c376e04ba4d00922852fa7c970402bb9476450f00b248346d847edc2500910c2253a984060ec9494057a23a05802c376e04ba4b00e228524c085eabe17271c18ea80bc030372e03ba4b00e229562c4104c0ad7451af98e82d8714d346e8c75d029040896209d51c326d846009019a68502a218b34f71d08729700c42b0b4095e26eb1605f5aa955fa7c3c4388336d846edc24005e5215cf01b4522347815d4b8be246a0875cf7ed03b84900a2295054e85aea640fc0b53453a958428efbf601dc2400718c502ca146316d8460679a39a058429e08809d895516802ae543a3827d69a14af192d05c11003ba3c3031001702f7e0e2aee030c25d96dfb006e128004862b7dde47b54401b89ac38ac140310c73db3e807b04208a42c5ccad0dd4e2376d8660218715f70120df6dd981dd2300318c5174cf6a95b3c608f6465d000adcb611e81e0188658c6209b58a812282dd511780221100bb12a32c0035e201b89c16aa1513838900d89604c53d8000b5b207e072021c54fc8d3319a478ded466b84500222951ccd7d248a55c0aee7a1a15bd3c8ff27b6633dc2200518c552ca156395054b03f0795b302148900d89128c629962002100e1c545e062c1601b023ea1e409d08401870884ac5e35e3205b025498a99007aa89583406140bbf281ef1c52dd140eec0e0188a044717ba689038a09a3042710a4417119308e3c624c9ba10fb708c004c5121ad86fda082124d42b477b0c27d6b411fa100138820840b8a02e0025220076435d00ea95934508cea05e792370849b4e04ba43005214d381f7c841a0b0e130358a015fc56e3a11e80601f0304af127699125c0b0a1875ac5d4ef6964bb271cd81d023049b18483549836420819758a1bbe5e46106dda085db84300262a962002104ea81ffb1ee59e8d4011008083949b36420819ea215f23c503b013e9142a7dbe873a59020c23eaa8510c071e2d1e809d18abf8733453210781c3884e6a68512a6108835cd1737087009ca5f8f9464a4d9b20849020358ae9c1a318e1967d001100382c021066a85f00730651a68dd0831b04407513503c8070a35a5900468b0760170691abf4f91eea241b709851a5bc0f201e806d98a0a8c5cdec95eb40c28c666ae9542aa1c42de1c0ce1780498ae9199ad863da0421c404a9540c078ea68408d366e8c0f902305959007699364108390714f70160bc08801df030415900f69a3642083995ca0230c6f17d0770be006493ad24003eb9123c2ca9e4a0620963c403b003672afe0c2d3201084beaa9a347a984d1ee380fe0740150dd031001084ffc54d2a454420af96ec80eec740150f5005a4500c294fd8afb00304e04c034518a33b1a02c01862dfb69542c61bc691374e06c01184aa6e2126095f26290e04cf68907004e1780f18a0b316dec306d8260886a1a142340c7b8e13c80d305402d22bb5d04206ce9a44af192b06c324d1ba18eb305609ca200880710ce547058e9f3118c316d823a4e7662a215d33204690ecb25402f092410472411f4e0a393663a099aae56c8a9a049f124e978de326d842a4e16801c32943c181ffb14f7829d8487740ac9238b4c5249248e28bcf8e9a683661aa9a18a722ae8305dd19051a1fcebabde4765039c2c00aaa9193bf8244cc6bd414c6022a3c8631899a49de057efa4815af653ce56d6b33d2c7224eea791a0d24afe38d326a813ce02d0c936d326584e021399c60486339cf453fcbd5872c8e12c7aa86417db58cb4af699aebcc534534d97d2459f0524d26ada0c359c2c0063943d80eda64db0100f794c673a6319cea03e8f7391e493cf5798cb4e3e6239eb5cec0b0429a7454900e22962b36933d470ae0044325c49008234bb361548341398cb5446903ba0368a6104c339874bd9c4625628c7ccd995329a95b6f23c8c150130c530c5dcec3eca68336d8405243185799c4309a94a61d21e0691c104cee313de663165a60db38032c5fb013ccedf0874ae00a8ded2deedc2094016b3b88471e490a825c2c3431ca328662a57b394d7f844f1461dbb5146b3d2e745000c324a04e028bce47225973292414ab3da1311c530b218c7e5bccb736c563c476f271a68a047a90f8cc1e3ec9d241100e713c948bec16c86916ad9ef19c120d219c95c96f1249bf099365a0b7ef6d14ef2803fef6110439c7dafa45305c0ab3c05e860a7692334104131dfe42ab289b73cacdb4b32a329602e4b78d4259e40296d0a0200518c74b60038951c361054787cbcedf8c39c5e8af92dfb6923a0d416fd7d027450c19f5d91156f1ebb95daa2833b4c9ba086533d80e18a1733f4b0d5d973374af83e37904454c885cc432cb9dcce953cc39fd8e7e88541d59d202fa34d9b109edc4ea59272b7709b69130688870846f238edf8433aee9fe8f153cb7f33d4c19e403c2b955aa087774c9b109efc0f8d4a3f5c23534c9b30003cc4329e27e830def58f7eeaf819431d9b23f7393a156c0f50ee58cb1d8c8717e8527a69ab49326d443ff192c078fe4c93f10e7fa2a78a1f3044fb066428f86fc5a1a48e91a64d50c199094152c852d2dd00a58a3160a1c54b32e3f8298bb95369cdda3ab2f92dcbb889a18ae733424fa9e201e84846983641adfa4ea44071fc0e382882db4b12f95cce2d14d85aae3d9cc19fb9993fb18a3a071d21daab2800519498364105670a4021894a9f778a007848a18859dcc44847fc52517c99b358ca23aca7d6217102a58a990123196eda04b5ea3b91026501b07f26000fc9143393eb19eba85f298e4b3987d778812dd429e6dd0d0555341250f0ad22c503083daa1e80cff6c9401329e17cae659223d79833b89559bccc1b6ca5017bc75bf450ce6485a8d2087289736e2235270a400cb98a61c035d49936e214c452cc74becab9c49baeca80f192c73f319b9758c22736cf27b0972e85f7c9430239ec366dc44071a2006491ae187a62df094014057c99cbb88014d355512692311433875759ca0e1be75e28555cb28ca658042094e4296e8505d96ada8413e22597e95cc42c069bae8a366299c61866f03acb953b9a5594d1a5f4f9688a4c9b30709c2800f9ca7be15b4c9bf0053c64721e7398ad98a9de8e24318733398f452ca3da86cb82a58a021045b16913068e330540358acf6e1e403217328b0b19eef8138a276308d730952fb188f7386cb365c13ac57d00f100424caea200b4526eda84a388633a17338b335cdbf98fe0a1906f72364b59c06a3a4d57e7287aa86082c26e4b1439c4dacaa27ee03c014864b062b8e95ec5d00f7d443295cbb880898a771c3a85482630827358c67cd6d9e818f15e7c0a02e02199a1949a366260384f008690ac3856da6302e06502977301934870f9d87f2c719cc318a6339f67a9325d995ef6d2ad945f22960211805091ed8a25c022beca1c269162ebf87eab48e62b8ce02bbcce4b8a7979f5b05731c7610cf9a64d18284e1400d52540d30290c53c2e6332990e4ea4a1a3152e651cb3789e371557e1d5d9a32800d1e418b660c0849f00048d6603cee022bec6596485c9acff54782964181398cd13ac35ba33504d334315266222002144750ad04083a19ac7f3256e663a598e3b336f1dd18c2297b359c21306b334fb2867b8425f8811010815510c514c075a6ae4986a3453b88df3c8b2497c7f1b5bf988c38c651a5946d7213c247226454ce7195e3026ce7b98a1d01722c820c1c6c1cea7c069029041aae2ebba2be4db4f5e86733b57904d9c0dd6fbbbd9c17cdea29c76fcc492c1642ee73c320cd6c94b2a673392abf83f161ae948e5f428f8651ee2c962af817a2be3340118a27c48664f48679b1e86713bd733cc069d3f480baff014db68a3a33724b7893af6b2805caee226f20dfa02910ce23cc672397f646dc80386cb14878518863a53009cc61cd62ba6afbc2e846befc9dcc9763a427c71c7899f833cc068124e62bd875886721b9bf019ad65806ef6f3c79027da9ca4981ab482eb425ce330e566f628be62678568248ee16b6ca0db78e70f10600f3f268dc8d35a1e412257f3a1e15a07e86137f79019c2f72a8306a53ad7f2c310d6368cf967ea957ea88e10bc565e6299cd07863b7e90203d74f03697f673cbd1c36c16dbe0e291755c4d5ac826257b9444af89df86a89e61cefd4ad73804d94eaaa5f5f392c8345e373eee07e9e6300b9833e0a5ad59bc4393e109410f6ff015924322026f2b095e27cf86a08e614f0c8f28be52f32dbc10c44b0a536c716f4f2735bccc6cc5c469515cc6db34d06dd496561ee64c922c9fb8fd9f92d8055826d11dd6338467155fa7df2b768a93e12185493cc821c3637f8076f6f12cb335c51bc4730d6f51a5780f93ea53cb7f32dae22b51fe4551e83e74612a17db318a058aafd2772dc8b2eb218d33f929a5c667cd6dece1692e56cc997c3c897c8d855419f604caf80925165e3e76bde2e47203132dab9bd0cb34de557c8de66a8f7c4861223f65073d863b7f077b7892398a7192272393db78930346d704fcace4464a2c4a943e4d71eab69d9996d44b388a8b15a300028cd73a974ce64cee618d6107394827bb7996ab2cce249cc51dbc43ad513fa79337f81af91604b065d1aa54b3bd5c6369eb5b84b322015315c7b7761ad115079848095fe16b4a974ae8c0c77ed6f01a6f73c8e26faae11156f0556633863443718d315cc239bcc6ab6ca45a6b50773d6d4a6f5734e9465a4411a70980da1a7eb5e2b9ef4f496024e77019e76a9e6df7971ef6b396c52ca23624dfe7e713fe97c55cc50cce3074c1ba870c6e6126afb290cd1a2f78f153ad948e3d4604c07ad405403dc63c9e517c994b9866f8a2ee0095ace62d168738b1968f756c670997713ea30c793f11e4731717329f77d8accdf3a96182c2a745002c278254c517ae4af128700c67f015e6708ec5e144a7a79ef758c25b5418f9f676de65034b99cb8514194a6d12cd384a98c92296b2454b62b16a824a49414c9ea71c304e1280045214eb5ba5e00144309299cce65cd20cb7430bab59c422c3d75135b190b5ac602673c831748a308eb3398319bccd52b6281f23ae56fa7434a944d8f0da93d3e0240148519e750ed403f030860b398fe90c32dc06edac6609cb596f8ba4da75bcc02a56318f99c6ee324ce23cce64068b59cc2ea5ec826a53292f0924d264a815068c93042049798f7b206b001e467131177076484fa79d081f1b788377d8603c89e6d154f214eb59ce3c6618cb7398c20cc6701ecb58c8de014ff3d43c0088254d04c04ae295c35bfb2b005e267231d3986abcf3f7b09905ac601d2dda36327511602b3bf888d95cc52463694f863097b3389f452ca47240fe91aa00c49066ab3ba7fa84b304406d09b087fa7e08402467318f2f31ded89ef7a704d9c9ebbcc3c71aa31874d3c33a76b19a397ccdd855991eb2b884f15cc4625ea7a6df6da52e00a9862c57209c04a09dce3ebe14d14ce50acee10c528c27f2dac77c16b28106db2f3035f32edb788fcbb8d2d805e75ef2c9e54c2e65212ff633c5682d01a56c51d18622239470920024280b405fba502c67f335cea144f90a3275ea799397594fad914cc6fd27481d4bd8ca3b5c6fd9a984d3734404c673052ff1723fa2043a6852dacb8fb249c6e77ee1240188531680d38dff294ce72aa6904fa2f1cedfc272fec147d4d06db826fda3877dd4b29985dcc239c6de2f2fb90ce30caee6795ea1b14f9f092a0a40a40880b5c428ae32b79f72692893395ccd7806db207f6f17eb798ca5d438f4d2e92e7653c91a66f30dc6196b4d2f39643386aff32c2f72b80f9fe850fa3ef1002c26ca2201f092c7d55c4e0969161d35ed0f3dece41116506d9b4bcc07429036b653c17b5ccf750c35568f0886329831dcc80bbc4ccd69feb6daf6aa780016a32a00be134c01a219c72dcc66088936b8aa3340250ff33c357d98aed89f002d6c60370bb8838b0c9e9c886430e98ce3565ee639ca4ef137d5fcad48c3e742075869e710a558dbe3d362a730876bf90a89c41877fa2148337fe3610ef479afc209f869e27d3630831f32c5a07f15491a1319cd2dcce7093e39892fa8e60178e5c2576bf909ed4a291bd67e96b5cdcb977988fd7418cfe3f3e9e3e329c6106d0321b28608d2b98bddc693a605e8a68a479972c2cefab652d987f91fd3cdec6eee534cdab491221298c1afd98ddf0689bb3f7f25df321841173a3c64f10baa6d20ba015a798d79a41fe715ae502ab599fb4d37b1bb51f500ea788b3adb74fc2041fcb4b18ab936587d081da3f83b0d361081200176f22b2692f299e7b546a9bc161e30ddb8eee6c78a59dbecf5f869661db73a71e558990b58c221e3d381234f27ef703763c82481cd4a25b5f107d30ddb7f9cb40818c42d8b63415a29e749fe4e836b6cea0fcb59c9b5fc90421b845ac7702117d2c55ade514ce911b4c511ed7ee2240108b8a2b30469653f8b78943db68feeb70e1fff6011dfe226f20ca7563b420c5fe6cb8a65f835659c0c294e12009fc38262bf489036f6f10e7f678b135f16cd1ce237cce70e2e22d71513a180137f532709409b62a8a6693ad8c70a9e66adc3edd047801dfc8457b98573c8b7f0d69f5059230260294e16804e2af8885778d77939632ca68b15ace37c6ee26c721cf53e1e8fdf56999afa88931abcdda102d0cd7e56f33acb2cbfbac3a9b4b1888fb9944b99c830430946d5f1d16aba0afdc74902d0e6c0e3313d54f2216fb24439df8cbb0952cddf7887795cca24d28def0d0c84ce3e9d38b4194e1280165a4c57a15f0468e00316b1c450f67ea711a08c8759c93c6630c15896e181d32502602d071dd4c0410eb292e52c65bb2b362f4345371fb393a55cc21c463b6c595004c0620ef631b38b799a58ce52969ff4d499702ada58c927ace4226653e8a013769d4e5ce3719200b472089fed5f883656b18077d9269d5f81832c64232bb8908bc875c85989f6105dd1aa152709809f065a6c7d05631beff1261fb2d1893bc2b6a3929759c3722e612e19b65f16ece190633cd4a370920040350db615800e56f13a1fb0cd89bbc13625c83e2ad9c05bcce5329b27ddeee0804372371f83b304a0825a4698aec409e8640d2fb38a4f1cb8516977fceca694b52ce66a2eb6f104b08d7da6ab30109c2500a58a17385a41276b7891d5eca255d6fb2dc2cf6e2af89885dccc39360d1412010801f5eca4c9463bc41d7cccf3bc47a9747ecbe9663b15ace12bdcc459365c116862a7e92a0c046709400f1fb38f71a6ab01401b6b78860f3860c3eb3add4a1b9bd8cb7bcce046ceb49508f8a9658fe94a84034379c50649bd5a58c875149260ab97305cf090c478ee639b0dde844f9f4649081a1abc7c9f03467fea5616731dd90e8b52731b5e9238837bd96a1311d8c31cd34d122e14b2c4d88fdec67c2e25dd06f70709e0218e11fc841dc645c0cf7b249a6e8e70c1c3f7d86fe0476ee171ce25c161ab266ec7433425fc3fca8c8ac041ee33dd10e14422ff50bc21a03f4f003f75fc9ac22fdc2c24d88508f2f82965f4189181009b0cde7e18964c664d48924af7d0ce7abeed8a8c75ee67183f663b6d214f377e881f9b363dfcb89a1d96fed0013a6860015f25c6b4a9423f48e11bace220dd21ebfe3edeb1455ee3b0e376ca2c92001f87d9cdc34c93c53e4712c73ce653456708ba7f8072e574e2c280f0f223f668968000ad1c6019f752e49023a8c289896026cf504ab3c5ab02f5fcc8b4a9e18b876bd9884fd34fd949151ff330f348336d98a089c9fc86cdd45b76136113bf9281c22ce7b194c38a3f6337356ce479ee64b8fc9c2e238251fc0b4b29a54d7bf73fc49f9dbf42e4fc8dad3cee662e2503d89f0fe2a3811aca59cd72b6d169da14c1123c643093d94c20870c6d12bf8f67f9851313811f8bf3050022b8845b18477e9f4f8b0769a6962acad9c05ab6d16cda04c172e219c70ca652422ec98aef7d0fdb7998c7dc90fac50d02001e3299c32cc69147da296cf2d1481d75d452ca3636b247527785151e0633952f319e4272067c94ab9ad5fc8d771c7f53656f93b8050f299ccb2446924306a92410450441bae8a085c31ca291060eb0973dec95cc3d614c14054c6202a328a280a47e25186961230b789efd6e49f9ea1e01388297344a18ca205289268a00edb4d2481db5d470d82d3f9ba04c24b98c650c79e4914b2ea9a7e90b410eb295d52c64bd9b568bdc260082d03f9228a090220ac966084318fc0529e8a69652f6b2958fd8ecfc65bf631101100480148630844c863088149288c74b80760e71886aca29a5ce89597f4f870880201c4b140924108b97009d34d12e13474110044110044110044110044110044110044110044110044110044110ecc9ff07fbcc603c64ccc35e0000002e7a545874646174653a637265617465000078da33323034d335b0d035b0083134b13236b23236d73630b0323000004227051508a258830000002e7a545874646174653a6d6f64696679000078da33323034d335b0d035b0083134b13236b23236d73630b03230000042270515219df00b000000707a5458747376673a626173652d757269000078da05c1010ec2200c05d013d53fb3b0456fd32120412869195cdff762fe853780c98ab516b297665eee011ba29c02b877642f0d5d43cd7785cd041bac748994ca5a28f214cd23907db907526e85f6d3b9cf716caf3d5ecefbe7c366fa03b3a82753efe1a9f10000000049454e44ae426082);

--
-- Contenu de la table `Product`
--

INSERT INTO `Product` (`idProduct`, `name`, `idImage`, `description`, `barcode`, `idFather`, `estimatedPrice`, `idGroup`) VALUES
(1, 'Produit test', 1, 'Produit test', NULL, NULL, NULL, 1),
(12, 'SubGeneralProduct', NULL, 'description', NULL, 1, NULL, NULL),
(13, 'Existing', NULL, 'Une description', 'Barre', NULL, 15.2, NULL),
(14, 'Custom', NULL, 'description', NULL, 1, NULL, 1),
(23, 'Existing', NULL, 'description', 'CodeBarre', NULL, 15.2, NULL),
(24, 'Existing', NULL, 'description', 'CodeBarre', NULL, 15.2, NULL),
(25, 'SubGeneralProduct', NULL, 'description', NULL, 1, NULL, NULL),
(26, 'SubGeneralProduct', NULL, 'description', NULL, 1, NULL, NULL),
(27, 'SubGeneralProduct', NULL, 'description', NULL, 1, NULL, NULL);

--
-- Contenu de la table `PricedProductList`
--

INSERT INTO `PricedProductList` (`idGroupList`, `idProduct`, `price`, `quantity`) VALUES
(1, 1, 12, 1);
--
-- Contenu de la table `Stats`
--

-- Contenu de la table `User`
--

INSERT INTO `User` (`idUser`, `nickname`, `firstname`, `lastname`, `email`, `birthdate`, `password`) VALUES
(1, 'flo4313', 'florian', 'smague', 'fsmague@gmail.com', '1998-03-28', '2db8d4f20e4e81aea665d0bf16d02aac991c5cd729cd0d838cff112817fc2835'),
(25, 'toto', 'toto', 'titi', 'toto@mail.fr', '3910-01-11', '6763be597d6fd0cdea48cee202a8abb3f78242688dab3cd349768c6f9dbd9259'),
(41, 'emma_cbrt', 'Emma', 'Cabaret', 'cabaret.emma@gmail.com', '1998-07-21', 'a6daa2bc6ed654114a68be4609cd219a5e6935f47b5087ad4b675ebe1a0ac1a0'),
(43, 'PepitoLRoiDuGato', 'Etienne', 'Saimond', 'etienne.saimond2@gmail.com', '1996-12-16', '32b3f03d51894066294e75884f955549a98d1982cccdae3233ecc31e6491dbad'),
(50, 'pepito123', 'vivuivv', 'yvyvvygv', 'uyvuyvu', '2019-12-13', '119228c1010c6de3c1aad3b2887eaddcf3108093f0c5d2a9a206d18cc78b7577'),
(51, 'pepito', 'Etienne', 'Saimond', 'etienne.saimond@gmail.com', '1996-12-16', 'a93c71b8208368a87f711ac38c8001be0f4ee95521ee02c6431fd2fa46f1923a'),
(52, 'emma', 'emma', 'cabaret', 'cabaret@gmail.com', '1998-07-21', '5c21b17bb7fb021de9c1837f596c230c35863a3dd8dad4ec22aada63afcd873'),
(53, 'sampleNickname', 'Prenom', 'Nom', 'email@email.com', '1997-04-12', 'password'),
(54, 'pepitooo', 'etienne', 'saimond', 'efsfesefs@gmail.com', '2020-01-16', 'e12d6c0f7d36dda2fd8a7c2eb759fb5b57341bc49533d6e6851608fcf4135b0e'),
(55, 'dorian', 'Dorian', 'Laurancy', 'dorian@mail.com', '1998-03-18', '25a2f6f6acaeddf97e3168b3466f3d859f70f29d257d64bc07996cf37cdc8e07');

INSERT INTO `Stats` (`idUser`, `date`, `amount`) VALUES
(1, '2019-12-09', 12.9),
(1, '2019-12-08', 100.9),
(1, '2019-12-10', 15.9),
(25, '2019-12-09', 45);

--
--
-- Contenu de la table `UserGroup`
--

INSERT INTO `UserGroup` (`idUser`, `idGroup`) VALUES
(1, 1),
(52, 1),
(54, 1),
(54, 2),
(54, 6),
(54, 7),
(52, 8),
(52, 9),
(52, 10),
(55, 12),
(55, 13),
(52, 14);

--
-- Contenu de la table `MessageSent`
--

INSERT INTO `MessageSent` (`idUser`, `idGroup`, `text`, `date`) VALUES
(1, 6, 'Oui', '2020-01-02'),
(25, 6, 'blblblbl', '2020-01-01'),
(54, 6, 'salut ', '2020-01-11');

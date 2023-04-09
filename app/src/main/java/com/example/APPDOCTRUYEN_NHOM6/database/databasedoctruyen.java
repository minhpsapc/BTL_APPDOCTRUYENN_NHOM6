package com.example.APPDOCTRUYEN_NHOM6.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.APPDOCTRUYEN_NHOM6.model.DanhGia;
import com.example.APPDOCTRUYEN_NHOM6.model.TaiKhoan;
import com.example.APPDOCTRUYEN_NHOM6.model.Truyen;


public class databasedoctruyen extends SQLiteOpenHelper{

    private static String DATABASE_NAME = "doctruyen";
    private static String TABLE_TAIKHOAN = "taikhoan";
    private static String ID_TAI_KHOAN = "idtaikhoan";
    private static String TEN_TAI_KHOAN = "tentaikhoan";
    private static String MAT_KHAU = "matkhau";
    private static String PHAN_QUYEN = "phanquyen";
    private static String EMAIL = "email";
    private static int VERSION = 2;

    private static String TABLE_TRUYEN = "truyen";
    private static String ID_TRUYEN = "idtruyen";
    private static String TEN_TRUYEN = "tieude";
    private static String NOI_DUNG = "noidung";
    private static String IMAGE = "anh";

    private static String TABLE_DANH_GIA = "danhgia";
    private static String ID_DANH_GIA = "iddanhgia";
    private static String NOI_DUNG_DANH_GIA = "noidungdanhgia";



    private Context context;

    private String SQLQuery = "CREATE TABLE "+ TABLE_TAIKHOAN +" ( "+ID_TAI_KHOAN+" INTEGER PRIMARY KEY AUTOINCREMENT, "
            +TEN_TAI_KHOAN+" TEXT UNIQUE, "
            +MAT_KHAU+" TEXT, "
            +EMAIL+" TEXT, "
            + PHAN_QUYEN+" INTEGER) ";

    private String SQLQuery1 = "CREATE TABLE "+ TABLE_TRUYEN +" ( "+ID_TRUYEN+" integer primary key AUTOINCREMENT, "
            +TEN_TRUYEN+" TEXT UNIQUE, "
            +NOI_DUNG+" TEXT, "
            +IMAGE+" TEXT, "+ID_TAI_KHOAN+" INTEGER , FOREIGN KEY ( "+ ID_TAI_KHOAN +" ) REFERENCES "+
            TABLE_TAIKHOAN+"("+ID_TAI_KHOAN+"))";

    private String SQLQuery13 = "CREATE TABLE "+ TABLE_DANH_GIA +" ( "+ID_DANH_GIA+" integer primary key AUTOINCREMENT, "
            +NOI_DUNG_DANH_GIA+" TEXT, "
            +TEN_TRUYEN+" TEXT, "
            +TEN_TAI_KHOAN+" TEXT,"
            +ID_TAI_KHOAN+" INTEGER , FOREIGN KEY ( "+ ID_TAI_KHOAN +","+TEN_TAI_KHOAN+" ) REFERENCES "+
            TABLE_TAIKHOAN+"("+ID_TAI_KHOAN+","+TEN_TAI_KHOAN+"))";



    private String SQLQuery2 = "INSERT INTO TaiKhoan VAlUES (null,'minh','123','khuatquangminh@gmail.com',2)";
    private String SQLQuery3 = "INSERT INTO TaiKhoan VAlUES (null,'vanh','123','vanh@gmail.com',1)";
    private String SQLQuery11 = "INSERT INTO TaiKhoan VAlUES (null,'cong','123','cong@gmail.com',1)";
    private String SQLQuery12 = "INSERT INTO TaiKhoan VAlUES (null,'linh','123','linh@gmail.com',1)";




    private String SQLQuery4 = "INSERT INTO truyen VALUES (null,'Doraemon','Mùa đông đã đến rồi trời lạnh buốt, Doraemon không có gì để ăn cả. Doraemon mặc áo vào rồi ra ngoài kiếm thức ăn. Nó đi mãi đi mãi cuối cùng cũng tìm được hai củ cải trắng. Doraemon reo lên:\n" +
            "\n" +
            "– Ôi, ở đây có hai củ cải trắng liền, mình thật là may mắn!\n" +
            "\n" +
            "Doraemon đói bụng, muốn ăn lắm rồi. Nhưng Doraemon lại nghĩ:\n" +
            "\n" +
            "– Ừm… trời lạnh thế này, chắc Nobita cũng không có cái gì để ăn đâu. Mình phải mang cho Nobita một củ mới được.\n" +
            "\n" +
            "Thế là Doraemon đi sang nhà bạn Nobita nhưng Nobita không có nhà nên Doraemon đặt củ cải lên bàn rồi đi về.\n" +
            "\n" +
            "Tình cờ, Nobita con đi chơi cũng tìm được một củ cải trắng nhưng nó chỉ ăn trước một nửa.\n" +
            "\n" +
            "Về đến nhà, lại thấy có một củ cải trắng ở trên bàn Nobita thèm ăn lắm, nhưng lại nghĩ:\n" +
            "\n" +
            "– Ôi trời lạnh thế này chắc Shizuka không có cái gì để ăn rồi, mình phải mang cho Shizuka mới được.\n" +
            "\n" +
            "Nobita con đến nhà Shizuka nhưng Shizuka lại đi vắng, Nobita bèn đặt củ cải ở trên bàn rồi về.\n" +
            "\n" +
            "Khi Shizuka về nhà, thấy củ cải ở trên bàn, Shizuka ngạc nhiên lắm.\n" +
            "\n" +
            "– Ồ, củ cải trắng ở đâu mà ngon vậy nhỉ. Xuỵt… thích quá. Nhưng chắc trời lạnh thế này, Doraemon cũng không có gì ăn đâu. Mình phải mang sang cho Doraemon mới được.\n" +
            "\n" +
            "Khi Shizuka đến thì Doraemon đang ngủ rất say. Khi tỉnh dậy Doraemon lại thấy trên bàn mình xuất hiện một củ cải trắng.Doraemon vui lắm nó chạy đi gọi các bạn:\n" +
            "\n" +
            "– Bạn Shizuka ơi, bạn Nobita ơi hãy đến nhà tôi, chúng ta cùng ăn củ cải trắng thơm ngon này.\n" +
            "\n" +
            "Thế là cuối cùng, củ cải trắng ấy được chia sẻ cho cả ba người bạn tốt bụng của chúng ta. Các bạn thấy đấy tấm lòng thơm thảo, sẵn sàng sẻ chia của các bạn ấy thật là đáng học tập phải không nào?\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Khi cho đi bạn sẽ nhận lại được nhiều hơn những thứ mình có.','https://cf.shopee.vn/file/2b496b60c912f6a488c7f3936bcd7883',1)";
    private String SQLQuery5 = "INSERT INTO truyen VALUES (null,'Cô bé lọ lem','Có lần, bố đi chợ phiên hỏi hai con của vợ kế muốn xin quà gì. Một cô xin quần áo đẹp, một cô xin ngọc. Bố lại hỏi:\n" +
            "\n" +
            "– Thế Lọ lem con muốn gì nào?\n" +
            "\n" +
            "– Thưa bố, trên đường về, có cành cây nào va vào mũ bố thì xin bố bẻ cho con.\n" +
            "\n" +
            "Bố mua về cho hai con vợ kế quần áo đẹp và ngọc. Trên đường về, khi đi qua một bụi cây xanh, có cành cây dẻ va phải ông và lật mũ ông. Ông bẻ cành ấy mang về. Tới nhà, ông cho hai con của vợ kế quà chúng xin và đưa cành dẻ cho Lọ lem. Lọ lem cảm ơn bố, đến mộ mẹ trồng cành dẻ lên, khóc lóc thảm thiết, nước mắt rơi xuống tưới ướt hết cành lá. Cành lớn rất mau thành một cây đẹp. Mỗi ngày, Lọ lem đến đó ba lần, lần nào cũng có con chim trắng tới đậu trên cây. Hễ cô ngỏ ý mong ước thứ gì thì chim vứt thứ ấy xuống cho cô.\n" +
            "\n" +
            "Một hôm, nhà vua mở hội ba ngày liền, mời tất cả các thiếu nữ xinh đẹp trong nước đến để Hoàng tử kén vợ. Hai cô con vợ kế nghe nói là mình cũng được đi thì mừng mừng rỡ gọi Lọ lem đến bảo:\n" +
            "\n" +
            "– Mày hãy chải đầu đánh giày cho chúng tao, cài giày cho chắc để chúng tao đi cho chắc để chúng tao đi lễ cưới ở cung vua.\n" +
            "\n" +
            "Lọ lem khóc lóc vâng lời, vì chính nó cũng muốn được đi cùng để nhảy. Nó xin mẹ kế cho đi. Mẹ kế bảo:\n" +
            "\n" +
            "– Đồ Lọ lem bẩn thỉu nhơ nhuốc mà cũng đòi đi dự hội à! Mày làm gì có giày, có quần áo đâu mà nhảy?\n" +
            "\n" +
            "Nó xin mãi thì mẹ kế bảo:\n" +
            "\n" +
            "– Tao đổ một đấu đỗ xuống tro. Cho mày nhặt hai tiếng đồng hồ, xong thì đi.\n" +
            "\n" +
            "Cô đi cửa sau vườn gọi:\n" +
            "\n" +
            "– Hỡi chim câu ngoan ngoãn, hỡi chim gáy, hỡi tất cả các chim trên trời, hãy lại đây nhặt giúp em, đỗ ngon thì bỏ vào nồi, đỗ xấu thì bỏ vào cổ họng.\n" +
            "\n" +
            "Lập tức có đôi chim bồ câu trắng bay qua cửa sổ nhà bếp vào, theo sau có chim gáy, rồi đến tất cả các chim trên trời rào rào bay tới đậu xuống quanh đống tro. Chim bồ câu gật gù rồi bắt đầu mổ lia lịa, những chim khác cũng mổ lia mổ lịa, nhặt đỗ tốt bỏ vào nồi. Chỉ non nửa tiếng đồng hồ, chim đã làm xong xuôi cả và bay đi. Cô gái mang đỗ đến cho gì ghẻ, chắc mẩm được đi dự hội. Nhưng gì ghẻ bảo:\n" +
            "\n" +
            "– Toi công thôi, Lọ lem ạ! Mày không đi cùng được đâu vì mày làm gì có quần áo mà nhảy? Chẳng nhẽ làm chúng tao xấu mặt vì quần áo của mày à?\n" +
            "\n" +
            "Nói rồi, mụ quay phắt đi, vội vã cùng hai đứa con gái đài các ra đi.\n" +
            "\n" +
            "Ở nhà không có ai, Lọ lem ra mộ mẹ, đến gốc cây dẻ gọi:\n" +
            "\n" +
            "– Cây ơi, cây hãy rũ vàng rũ bạc xuống đây cho em.\n" +
            "\n" +
            "Chim liền ném xuống cho cô một chiếc áo bằng vàng bằng bạc và một đôi hài lụa thêu chỉ bạc. Cô vội mặc quần áo vào đi dự hội. Dì ghẻ và hai em không nhận được ra cô, tưởng là một nàng công chúa nào xa lạ vì cô mặc áo vàng trông đẹp lộng lẫy. Chúng không ngờ chút nào đó là Lọ lem, đinh ninh là cô vẫn lúi húi nhặt đỗ trong đống tro. Hoàng tử lại đón cô, cầm tay cô nhảy. Chàng không muốn nhảy với ai khác nữa, và không chịu rời tay cô ra. Có ai đến mời cô\n" +
            "nhảy thì chàng nói:\n" +
            "\n" +
            "– Đây là bạn nhảy cùng tôi.\n" +
            "\n" +
            "Cô nhảy đến tối thì xin về. Hoàng tử ngỏ ý muốn đưa cô về vì chàng muốn biết cô thiếu nữ xinh đẹp này là con cái nhà ai. Cô gỡ tay Hoàng tử ra và nhảy vào chuồng bồ câu. Hoàng tử đợi đến khi ông bố đến liền bảo cô gái lạ mặt đã nhảy biến mất vào chuồng bồ câu. Ông cụ nghĩ: phải chăng là Lọ lem?\n" +
            "\n" +
            "Cụ bắt mang đến cho cụ rìu và mai để cụ chẻ tan chuồng ra. Chẻ xong chẳng thấy có ai ở trong. Họ về nhà thì thấy Lọ lem mặc quần áo nhem nhuốc ngồi trong đống tro, một ngọn đèn dầu tù mù cháy trên lò sưởi. Thì ra Lọ lem đã nhảy phắt ra khỏi chuồng bồ câu, chạy vội đến cây dẻ, cởi quần áo đẹp ra để trên mộ. Chim xuống cất đi ngay. Rồi cô lại mặc quần áo xám xì vào, ngồi trên đống tro trong bếp như cũ.\n" +
            "\n" +
            "Hôm sau, hội lại tiếp tục. Bố mẹ và hai em đi khỏi, Lọ lem lại đến cây dẻ gọi:\n" +
            "\n" +
            "– Cây ơi, hãy rũ vàng rũ bạc xuống đây cho em.\n" +
            "\n" +
            "Chim lại thả xuống một bộ quần áo lộng lẫy hơn hôm trước. Cô mặc quần áo ấy đến dự lễ. Cô đẹp quá, làm mọi người ngẩn người ra. Hoàng tử đã đợi cô, liền cầm tay cô và chỉ nhảy với cô thôi. Các người khác đến mời cô nhảy thì Hoàng tử bảo: “Đây là bạn nhảy của tôi”. Đến tối, cô xin về, Hoàng tử đi theo xem cô đến nhà nào, cô vội gạt Hoàng tử ra chạy vào vườn sau nhà. ở đấy có một cây lê to rất đẹp, chi chít những quả ngon lành. Cô trèo lên nhanh như sóc rồi đi\n" +
            "đâu mất. Hoàng tử đợi đến khi ông bố đến bảo:\n" +
            "\n" +
            "– Cô gái lạ mặt đã đánh tháo khỏi tay ta. Có leo cô ấy nhảy lên cây lê rồi.\n" +
            "\n" +
            "Ông bố nghĩ: – Phải chăng là Lọ lem!\n" +
            "\n" +
            "Ông cho mang rìu đến, đẵn cây xuống, nhưng chẳng có ai trên cây.\n" +
            "\n" +
            "Cả nhà vào bếp thì thấy Lọ lem nằm trong đống tro như không có việc gì xảy ra. Thì ra cô đã nhảy từ phía bên kia cây xuống, đem trả quần áo đẹp cho chim trên cây dẻ và mặc quần áo xám xì vào. Đến ngày thứ ba, bố mẹ và các em đi khỏi, Lọ lem lại ra mộ mẹ bảo cây:\n" +
            "\n" +
            "– Cây ơi, cây hãy rũ vàng rũ bạc xuống đây cho em.\n" +
            "\n" +
            "Chim liền nhả xuống một bộ quần áo lộng lẫy nhất đời và một đôi hài toàn bằng vàng. Khi cô mặc vào đi dự lễ, mọi người cứ thần người ra nhìn. Hoàng tử chỉ nhảy với cô, có ai mời cô nhảy thì chàng nói: – Đây là bạn nhảy của tôi.\n" +
            "\n" +
            "Đến tối, Lọ lem xin về. Hoàng tử định đưa về, nhưng cô lẩn nhanh như cắt, Hoàng tử đã nghĩ ra một mẹo là cho đổ nhựa thông lên thang. Khi cô nhảy đi thì chiếc giày bên trái dính lại. Hoàng tử cầm lên thì thấy chiếc hài xinh đẹp toàn bằng vàng. Hôm sau, Hoàng tử mang hài đến tìm ông bố bảo:\n" +
            "\n" +
            "– Ta chỉ lấy ai chân đi vừa chiếc hài này thôi.\n" +
            "\n" +
            "Hai chị có đôi chân đẹp nên mừng lắm. Cô cả mang giày vào buồng thử trước mặt mẹ. Nhưng cô không đút ngón chân cái vào được vì hài nhỏ quá. Mẹ liền đưa cho cô con dao bảo:\n" +
            "\n" +
            "– Mày cứ chặt ngón cái đi. Mày thành hoàng hậu rồi thì cần gì đi bộ nữa.\n" +
            "\n" +
            "Cô ta liền chặt ngón cái, nhét chân vào hài rồi cắn răng chịu đau, đến ra mắt hoàng tử. Hoàng tử nhận cô làm vợ đặt lên ngựa cùng về. Khi đi qua mộ thì đôi chim câu đậu trên cây dẻ kêu lên:\n" +
            "\n" +
            "Cúc cu cu!\n" +
            "Hoàng tử nhìn xem\n" +
            "Chiếc hài vấy máu.\n" +
            "Vì chân dài quá\n" +
            "Nên phải chặt chân\n" +
            "Chính cô dâu thật\n" +
            "Vẫn ở trong nhà!\n" +
            "\n" +
            "Hoàng tử nhìn xuống chân cô thấy máu chảy, liền quay ngựa lại, đưa cô về nhà trả lại cho bố mẹ cô. Hoàng tử bảo không đúng là cô dâu thật, rồi cho cô em thử hài. Cô em thử hài thì may sao các ngón vào được lọt cả. Nhưng phải cái gót lại to quá. Bà mẹ đưa cho con dao bảo:\n" +
            "\n" +
            "– Mày cứ chặt đi một miếng gót chân. Mày mà được làm hoàng hậu thì chả bao giờ phải đi chân nữa.\n" +
            "\n" +
            "Cô gái chặt một miếng gót chân, cố đút chân vào hài, cắn răng chịu đau, ra gặp hoàng tử.\n" +
            "Hoàng tử đặt cô dâu lên ngựa đi. Đi qua cây dẻ đôi chim câu đậu trên cành hót:\n" +
            "\n" +
            "Cúc cu cu!\n" +
            "Hoàng tử nhìn xem\n" +
            "Chiếc hài vấy máu.\n" +
            "Vì chân dài quá\n" +
            "Nên phải chặt chân\n" +
            "Chính cô dâu thật\n" +
            "Vẫn ở trong nhà!\n" +
            "\n" +
            "Hoàng tử nhìn xuống thấy máu ở hài chảy ra, thấm đỏ cả tất trắng, quay ngựa, mang cô dâu trả về nhà bố mẹ cô mà bảo:\n" +
            "\n" +
            "– Đây cũng chưa phải cô thật. Ông còn cô con gái nào khác không?\n" +
            "\n" +
            "Ông bố đáp:\n" +
            "\n" +
            "– Thưa Hoàng tử không ạ. Chỉ có con Lọ lem bé tí, xanh xao là con vợ cả đã chết. Thứ nó thì chả làm cô dâu được!\n" +
            "\n" +
            "Hoàng tử bảo cứ cho gọi ra. Dì ghẻ thưa:\n" +
            "\n" +
            "– Thưa hoàng tử, không nên. Nó bẩn thỉu quá, trông tởm lắm.\n" +
            "\n" +
            "Hoàng tử nhất định đòi Lọ lem lên kỳ được. Cô rửa mặt mũi chân tay, đến cúi chào Hoàng tử. Hoàng tử đưa cho chiếc hài. Cô ngồi lên ghế đẩu, rút chân ra khỏi chiếc guốc gỗ thô kệch, đút chân vào chiếc hài vừa như in. Cô đứng dậy, Hoàng tử thấy mặt thì nhận ra cô gái xinh đẹp đã nhảy với mình bèn phán:\n" +
            "\n" +
            "– Cô dâu thật đây rồi!\n" +
            "\n" +
            "Dì ghẻ và hai con sợ quá, tái mặt đi. Hoàng tử đặt Lọ lem lên ngựa đi. Khi qua cây dẻ, đôi chim câu hót:\n" +
            "\n" +
            "Cúc cu, hãy trông kìa!\n" +
            "Cúc cu cu!\n" +
            "Hoàng tử nhìn xem\n" +
            "Hài không có máu\n" +
            "Vì hài vừa quá\n" +
            "Không phải chặt chân\n" +
            "Đúng cô dâu thật\n" +
            "Hoàng tử đưa về.\n" +
            "\n" +
            "Hót xong, đôi chim câu bay khỏi cây, xuống đậu trên vai cô Lọ lem, một con bên trái, một con bên phải.','https://truyencotich.vn/wp-content/uploads/2012/10/Cinderella-Wallpaper-cinderella-6492857-1024-768-660x440.jpg',1)";
    private String SQLQuery6 = "INSERT INTO truyen VALUES (null,'One Piece','Luffy đen và Luffy trắng cùng sống trong một khu rừng. Hàng ngày, cả hai thường đến uống nước và tìm cái ăn ở trong khu rừng quen thuộc.\n" +
            "\n" +
            "Một hôm, Luffy trắng đi tìm cái ăn và uống nước suối như mọi khi. Luffy đang mải mê ngặm cỏ, bất chợt một con Sói ở đâu nhảy xổ ra. Sói quát hỏi:\n" +
            "\n" +
            "- Luffy kia! Mi đi đâu?\n" +
            "\n" +
            "Luffy trắng sợ rúm cả người, lắp bắp:\n" +
            "\n" +
            "– Dạ, dạ, tôi đi tìm… tìm cỏ non và…và uống nước suối ạ!\n" +
            "\n" +
            "Sói lại quát hỏi:\n" +
            "\n" +
            "– Mi có gì ở chân?\n" +
            "\n" +
            "– Dạ, dạ, chân của tôi có móng ạ…ạ!\n" +
            "\n" +
            "– Trên đầu mi có gì?\n" +
            "\n" +
            "– Dạ, dạ, trên đầu tôi có đôi sừng mới nhú…\n" +
            "\n" +
            "Sói càng quát to hơn:\n" +
            "\n" +
            "– Trái tim mi thế nào?\n" +
            "\n" +
            "– Ôi, ôi, trái…trái tim tôi đang run sợ…sợ…\n" +
            "\n" +
            "– Hahaha…\n" +
            "\n" +
            "Sói cười vang rồi ăn thịt chú Luffy trắng tội nghiệp\n" +
            "\n" +
            "Luffy đen cũng đi tới khu rừng để ăn cỏ non và uống nước suối. Đang tha thẩn ngặm cỏ, chợt Sói xuất hiện, nó quát hỏi:\n" +
            "\n" +
            "– Luffy kia, mi đi đâu?\n" +
            "\n" +
            "Luffy đen nhìn con Sói từ đầu tới chân rồi ngước cổ trả lời:\n" +
            "\n" +
            "– Ta đi tìm kẻ nào thích gây sự đây!\n" +
            "\n" +
            "Sói bị bất ngờ, nó hỏi tiếp:\n" +
            "\n" +
            "– Thế dưới chân mi có gì?\n" +
            "\n" +
            "– Chân thép của ta có móng bằng đồng.\n" +
            "\n" +
            "– Thế…thế…trên đầu mi có gì?\n" +
            "\n" +
            "– Trên đầu của ta có đôi sừng bằng kim cương!\n" +
            "\n" +
            "Sói sợ lắm rồi, nhưng vẫn cố hỏi:\n" +
            "\n" +
            "– Mi…mi…trái tim mi thế nào?\n" +
            "\n" +
            "Luffy đen dõng dạc trả lời:\n" +
            "\n" +
            "– Trái tim thép của ta bảo ta rằng: hãy cắm đôi sừng kim cương vào đầu Sói. Nào, Sói hãy lại đây.\n" +
            "\n" +
            "Ôi trời, sợ quá, con Sói ba chân bốn cẳng chạy biến vào rừng, từ đó không ai trông thấy nó lởn vởn ở khu rừng đó nữa.\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Qua câu chuyện ngụ ngôn trên, bạn có thể truyền tải nhiều thông điệp khác nhau cho bé hiểu. Chẳng hạn như biết cách ứng xử trước các tình huống khó, nguy hiểm, lạc quan và bản lĩnh để xử lý vấn đề.','https://www.cgv.vn/media/catalog/product/cache/1/image/c5f0a1eff4c394a251036189ccddaacd/p/o/poster_one_piece_3_-_final_main_version_1_.jpg',1)";
    private String SQLQuery7 = "INSERT INTO truyen VALUES (null,'CHÚ CUỘI CUNG TRĂNG','Ngày xửa ngày xưa có một người tiều phu tên là Cuội. Một hôm, Cuội vác rìu vào rừng sâu chặt cây, bất ngờ gặp một hang Cọp. Cuội liền xông đến vung rìu bổ cho mỗi con một nhát lăn quay trên mặt đất. Vừa lúc đó, cọp mẹ về tới. Cuội sợ hãi trèo thót lên cây cao.\n" +
            "\n" +
            "Từ trên cây nhìn xuống, Cuội thấy cọp mẹ đi đến một gốc cây gần chỗ Cuội ẩn, đớp lấy một ít lá rồi trở về nhai và mớm cho Cọp con. Ít giây sau Cọp con sống lại, Cuội vô cùng kinh ngạc chờ Cọp Mẹ tha Cọp con đi lần xuống tìm đến cây lạ kia đào gốc mang về. Trên đường về Cuội đã cứu một ông lão ăn mày nằm chết trên bãi cỏ, bằng chính lá cây lạ đó.\n" +
            "\n" +
            "Ông lão sống lại và dặn dò Cuội đây là cây cải tử hoàn sinh nên phải tưới bằng nước sạch, nếu không cây bay lên trời. Từ ngày có cây thuốc quý, Cuội cứu sống được rất nhiều người. Hễ nghe nói có ai nhắm mắt tắt hơi là Cuội vui lòng mang lá cây đến tận nơi cứu chữa.\n" +
            "\n" +
            "Tiếng đồn Cuội có phép lạ lan đi khắp nơi. Một chiều Cuội đi rừng kiếm củi, người vợ ở nhà không nhớ lời chồng dặn, tưới nước bẩn làm cây quý bay lên trời. Cuội về nhà thấy thế ,hốt hoảng vứt gánh củi, nhảy bổ đến, toan níu cây lại. Nhưng cây lúc ấy đã rời khỏi mặt đất lên quá đầu người.\n" +
            "\n" +
            "Cuội chỉ kịp móc rìu vào rễ cây, định lôi cây xuống, nhưng cây vẫn cứ bay lên. Cuội cũng nhất định không chịu buông, nên cây kéo cả Cuội bay vút lên đến cung trăng.Từ đó về sau, Cuội ở lại trên cung trăng cùng cây quý của mình.','https://o.rada.vn/data/image/2021/04/29/ke-lai-su-tich-chu-cuoi-cung-trang.jpg',1)";
    private String SQLQuery8 = "INSERT INTO truyen VALUES (null,'Alibaba và 40 tên cướp','Thuở xưa tại vương quốc Iraq có hai anh em là Casim và AliBaba. Casim, người anh chiếm đoạt hết tài sản do cha mẹ để lại đồng thời lại lấy được vợ giàu sang nên có một đời sống dư giả rất sung túc. Trái lại AliBaba vì không muốn tranh đoạt gia tài với anh ruột lại lấy phải vợ nghèo nên đời sống khá chật vật, chỉ đủ qua ngày. Hàng ngày Ali Baba phải đi lên rừng đốn củi đem về bán để kiếm sống. Thấy em nghèo túng, Casim và vợ không những không thương xót giúp đỡ mà còn tỏ vẻ lạnh lùng, khinh khi ra mặt. Nhưng Ali Baba vẫn không vì thế mà phiền lòng hay bất mãn, vẫn thường qua lại thăm hỏi anh mình và chị dâu cho phải đạo làm em.\n" +
            "\n" +
            "Hôm ấy như thường lệ, Ali Baba lên rừng đi lấy củi. Xong việc, chàng chất củi vào hai túi hai bên hông con lừa. Đang định lên đường về lại nhà bỗng nhìn thấy cát bụi mịt mù từ đàng xa, rồi kế đến là tiếng vó ngựa dồn dập mỗi lúc một gần. Ali Baba hoảng hốt, dắt lừa vào núp trong một bụi rậm, nhưng vẫn để ý nghe ngóng.\n" +
            "\n" +
            "Rồi tiếng vó ngựa bỗng im bặt… Một đoàn kỵ sĩ trông dữ dằn, mang đao kiếm đầy mình dừng lại bên cạnh một tảng đá lớn trông chẳng khác gì một quả núi. Chung quanh tảng đá, rêu cỏ, cây cối mọc rậm rạp bao phủ kín mít. Nếu ai từ xa ngắm lại ắt chỉ nhìn thấy một khối xanh rì.\n" +
            "\n" +
            "Ali Baba đếm được trước sau 40 người và 40 ngựa. Người nào cũng tháo gỡ một chiếc túi lớn từ trên lưng hay từ hai bên hông ngựa xuống; có người thì hai túi, kẻ ba túi… Đoàn người cùng nhau tiến tới sát bên tảng đá. Người đi đầu, có lẽ là thủ lãnh của đám người bỗng ra dấu cho tất cả dừng lại trước rồi giơ hai tay lên trời nói lớn:\n" +
            "\n" +
            "-Vừng ơi mở cửa ra!\n" +
            "\n" +
            "Lạ lùng thay, tảng đá lâu nay mà Ali Baba đi ngang qua không biết bao nhiêu lần mà không bao giờ để ý như có một cánh cửa tự động mở ra, và bên trong sâu hun hút tựa như là một hang động. Đoàn người ôm hành trang cùng vào tất cả bên trong. Người thủ lãnh là người đi sau cùng. Y lại giơ hai tay lên trời nói:\n" +
            "\n" +
            "– Vừng ơi, hãy đóng lại!\n" +
            "\n" +
            "Lập tức cánh cửa đóng lại. Và bây giờ trông tảng đá khổng lồ lại giống như một hòn núi khi nãy, không có gì đáng chú ý cả. Ali Baba vẫn núp kín, không dám chường mặt ra, sợ đoàn người kia phát hiện thì có thể nguy đến tánh mạng của chàng không chừng. Phải đợi đến cả giờ đồng hồ sau, chàng mới nghe được tiếng:\n" +
            "\n" +
            "-Vừng ơi mở cửa ra!\n" +
            "\n" +
            "Rồi đoàn người 40 mạng từ từ lần lượt bước ra ngoài. Người thủ lãnh lại giơ hai tay lên trời nói:\n" +
            "\n" +
            "– Vừng ơi, hãy đóng lại!\n" +
            "\n" +
            "Đoàn người sau đó lên ngựa. Cát bụi lại bay mù mịt khắp trời pha lẫn với tiếng vó câu rang rền. Chỉ trong nháy mắt, đoàn kỵ sĩ đã mất hút, trả lại sự im lặng cho chốn núi rừng. Đoàn người đi rồi, Ali Baba mới dám ra khỏi chỗ núp. Do tính tò mò thúc đẩy, thay vì lên đường về nhà chàng đến trước tảng đá đưa hai tay lên nói:\n" +
            "\n" +
            "-Vừng ơi mở cửa ra!\n" +
            "\n" +
            "Lập tức cánh cửa được mở ra. Chàng nhìn thấy rõ bên trong là một hang động đúng như chàng đoán. Đã đến nước này, Ali Baba quyết định phải vào tham xét một chuyến. Nghĩ đoạn, chàng liền dắt luôn con lừa vào trong rồi đưa hai tay lên nói:\n" +
            "\n" +
            "-Vừng ơi, hãy đóng lại!\n" +
            "\n" +
            "Và cửa động đã được đóng kín sau đó. Nhìn thấy ánh sáng từ đâu trong động lóe ra, Ali Baba bèn nhắm hướng đó mà đi. Vừa đến nơi, chàng kêu lên một tiếng vì kinh ngạc. Trước mặt chàng, một kho tàng khổng lồ không ai có thể tưởng tượng nổi, cho dù là ở trong truyện cổ tích. Ôi chao! Nào là kim cương, vàng bạc châu báu, lại thêm không biết bao nhiêu là nhung lụa, những tấm thảm thật đẹp lộng lẫy ngay cả trong cung điện vua chúa cũng không thể nào có được. Ôi thì trăm ngàn thứ, vật nào cũng quý giá cả! Chàng thầm nghĩ.\n" +
            "\n" +
            "-“Vậy thì 40 người đó chắc hẳn là cướp rồi. Thì ra chúng đi cướp khắp nơi, dùng địa điểm này là nơi dự trữ, cất giấu các bảo vật cướp được chứ chẳng chạy vào đâu! Ta phải mau ra khỏi nơi đây kẻo chúng trở lại ắt nguy đến tánh mạng!”.\n" +
            "\n" +
            "Nhưng dù sao Ali Baba vẫn chỉ là con người. Hỏi có mấy ai khi đứng trước một kho tàng vĩ đại như thế này mà không động lòng bao giờ! Chàng đánh liều, gom góp một số vàng bạc châu báu thật nhiều nhét vào đầy các túi dùng để củi hai bên hông lừa rồi lấy củi ngụy trang ở phía trên. Xong xuôi, chàng liền dùng câu thần chú nghe được để mở cửa động rồi đóng lại cẩn thận như không có gì xảy ra.\n" +
            "\n" +
            "Về đến nhà, Ali Baba đóng kín cửa ngõ trước sau rồi bắt đầu đem ‘chiến lợi phẩm’ ra khoe với vợ. Vợ chàng kinh hãi, tưởng chàng trộm cướp của nhà giàu đem về nên tỏ vẻ không bằng lòng nói:\n" +
            "\n" +
            "-Nhà mình dù nghèo nhưng từ trước vẫn sống một đời lương thiện. Tại sao chàng lại nổi máu tham lam làm những chuyện phi luân như vậy?\n" +
            "\n" +
            "Biết vợ mình hiểu lầm, Ali Baba liền đem chuyện kể lại cho vợ nghe từ đầu đến cuối. Nghe xong, vợ chàng tươi ngay nét mặt, hết dị nghị. Nhìn đống vàng bạc châu báu mà cả hai vợ chồng cùng thấy ‘ớn lạnh’, không tài nào đếm nổi. Ali Baba liền đề nghị:\n" +
            "\n" +
            "– Hay là em sang mượn cái đấu đong gạo bên nhà anh Casim để về mà đếm có tiện hơn không?\n" +
            "\n" +
            "Vợ chàng khen phải nên chạy vội sang nhà anh chàng mượn cái đấu. Vợ Casim lấy làm lạ nghĩ thầm:\n" +
            "\n" +
            "– Quái lạ! Xưa nay vợ chồng Ali Baba nghèo khổ, may ra bán củi xong chỉ mua được vừa đủ gạo nấu từng bữa thôi thì cần gì phải dùng đến cái đấu làm gì? Không lẽ hai vợ chồng vừa trúng mối nên mua được một số gạo lớn.\n" +
            "\n" +
            "Người vợ Casim đi lấy đấu. Y thị lấy một ít hắc ín (dầu hắc, nhựa đường) trét vào dưới đáy bên trong cái đấu gạo với mục đích tò mò, muốn xem thử gia đình Ali Baba ăn loại gạo gì. Vợ Ali Baba mượn được đấu xong thì cám ơn rối rít ra về.\n" +
            "\n" +
            "Hai vợ chồng Ali Baba lúi húi đong từng đấu một để đếm số vàng bạc châu báu. Phải mất một hồi lâu hai người mới ‘đong’ xong số vàng bạc châu báu. Sau đó, vợ Ali Baba đem cái đấu sang trả lại cho gia đình Casim. Một đồng tiền vàng dính chặt dưới đáy bên trong cái đấu gạo chỗ vợ Casim trét hắc ín nhưng vợ chồng Ali Baba vô tình không hay biết gì cả.\n" +
            "\n" +
            "Nhìn đồng tiền vàng dính dưới đáy trong cái đấu, vợ của Casim hết sức kinh ngạc thốt lên:\n" +
            "\n" +
            "-Trời! Không lẽ chúng nó giàu đến độ phải dùng đấu để đong vàng?\n" +
            "\n" +
            "Casim vừa về đến nhà thì mụ đã chạy ra the thé rằng:\n" +
            "\n" +
            "-Anh vào đây xem này. Ali Baba em của anh xưa nay chỉ giả vờ nghèo thôi chứ sự thật hắn còn giàu có gấp trăm ngàn lần vợ chồng mình nữa!\n" +
            "\n" +
            "Casim ngạc nhiên hỏi:\n" +
            "\n" +
            "-Chuyện gì?\n" +
            "\n" +
            "Mụ vợ của Casim liền đưa cái đấu có dính đồng tiền vàng và kể lại mọi chuyện. Casim nghe xong, lòng ganh tị và căm tức nổi lên. Hắn nói với vợ:\n" +
            "\n" +
            "-Mụ ở nhà, để tôi sang hỏi Ali Baba xem sao. Hừ, nếu quả thật là vậy tôi sẽ lên cáo quan cho nó biết mặt.\n" +
            "\n" +
            "Nói xong, Casim hậm hực sang ngay nhà em mình. Thấy anh đột ngột đến thăm, Ali Baba hơi ngạc nhiên nhưng vẫn tiếp đón niềm nở. Casim lạnh lùng nói:\n" +
            "\n" +
            "-Chú giàu có thì tôi mừng cho chứ làm gì mà phải giả nghèo giả khó như thế?\n" +
            "\n" +
            "Ali Baba nghe nói vội xua tay:\n" +
            "\n" +
            "-Đâu có! Em làm gì mà giàu có? Anh cũng thừa biết cảnh nghèo nàn của em từ lâu rồi phải không?\n" +
            "\n" +
            "Casim lấy cái đấu, chỉ đồng tiền vàng dưới đáy nói:\n" +
            "\n" +
            "-Thế cái này là cái gì đây? Ôi chao, vàng nhiều đến nỗi phải đong mà còn chối cãi bảo là nghèo à?\n" +
            "\n" +
            "Biết chuyện đã bại lộ, Ali Baba bèn đem chuyện từ lúc vào rừng gặp bọn cướp, khám phá ra hang động vào kho tàng ra sao nhất nhất kể lại cho Casim nghe. Chàng ta cũng không quên nói cho anh biết cả câu thần chú dùng để mở cửa hay đóng cửa hang ra sao.\n" +
            "\n" +
            "Casim tươi hẳn nét mặt, vênh váo nói:\n" +
            "\n" +
            "-Có thế chứ! Vậy là chú biết điều đó. Bằng không thì tôi đem chuyện này nói lại với bọn cướp thì chú mất mạng như chơi!\n" +
            "\n" +
            "Casim chạy vội về nhà kể lại cho vợ nghe. Hai vợ chồng hết sức vui mừng, suốt đêm không ngủ được. Sáng hôm sau, Casim đem mười con lừa thật lớn và thật khỏe. Trên lưng mỗi con là hai túi vải thật lớn. Chuẩn bị xong xuôi đâu đó, Casim ăn mặc giả làm người đi kiếm củi, thẳng đường lên rừng.\n" +
            "\n" +
            "Tới đúng địa điểm, Casim giơ hai tay lên trời nói:\n" +
            "\n" +
            "– Vừng ơi mở cửa ra!\n" +
            "\n" +
            "Tức thì cánh cửa động mở toang ra. Casim dẫn đàn lừa vào trong. Nhìn thấy ánh sáng rực rỡ như hào quang, Casim biết ngay đã tìm thấy kho tàng. Y đi nhanh tới thì quả đúng như lời Ali Baba nói với y, một kho tàng lớn vĩ đại, với kim cương hột xoàn, ngọc ngà châu báu, vàng bạc, gấm vóc nhung lụa, những tấm thảm quý giá lớn nhỏ đủ cỡ cũng không thiếu. Ôi thì không biết sao mà diễn tả cho được. Dẫu ai có nằm mơ cũng không tưởng tượng ra nổi rằng trên thế gia lại có được một kho tàng như thế này!\n" +
            "\n" +
            "Bụng tham lam của Casim nổi dậy. Đôi mắt y sáng rực lên. Rồi tay bốc vàng, tay vơ bạc, y chất đầy trên các túi trên lưng mười con lừa. Chưa vừa lòng, y còn nhét vào mình, bất cứ chỗ nào bỏ được gì hắn đều không từ. Sau khi thấy tạm đủ cho một hôm, hắn bèn dắt đàn lừa ra ngoài, trong lòng sung sướng, mơ tưởng đến cảnh giàu sang của gia đình hắn trong những ngày sắp tới. Đến cửa động, hắn giơ hai tay lên nói:\n" +
            "\n" +
            "– Hỡi thần Mè mở cửa ra!\n" +
            "\n" +
            "Cánh cửa vẫn khép kín không động đậy. Casim thầm kêu khổ trong lòng, nghĩ thầm:\n" +
            "\n" +
            "-Thôi chết! Mình quên mất câu thần chú rồi!\n" +
            "\n" +
            "Nặn óc một hồi, hắn kêu ‘a’ một tiếng rồi lại giơ hai tay lên nói:\n" +
            "\n" +
            "-Hỡi thần Mẻ, hãy mở ra!\n" +
            "\n" +
            "Cánh cửa vẫn không động đậy. Casim sau đó đọc thần chú liên tiếp giờ này sang giờ nọ. Hết ‘thần Mê’ đến ‘thần Mì’…, nhưng không làm sao nhớ được hai chữ “Vừng ơi”.\n" +
            "\n" +
            "Casim càng lúc càng lo sợ. Hắn biết bọn cướp có thể trở về bất cứ lúc nào. Hắn khấn thầm, cầu nguyện với thánh ‘Allah’ giúp cho hắn nhớ lại câu thần chú để thoát thân chứ không còn dám nghĩ đến chuyện ham giàu có nữa. Nhưng có lẽ vì hắn xưa nay chưa hề tu nhân tích đức nên không được Allah độ cho. Casim bắt đầu run sợ. Và điều run sợ sau cùng đã đến.\n" +
            "\n" +
            "– Vừng ơi mở cửa ra!\n" +
            "\n" +
            "Casim biết ngay bọn cướp đã trở về. Trong một giây suy nghĩ, hắn biết chỉ còn một đường liều mạng cuối cùng mà thôi. Cánh cửa vừa mở ra, Casim dùng hết sức bình sinh chạy thẳng ra ngoài, xô ngã một tên cướp đặng tìm đường tẩu thoát. Nhưng bọn cướp đã chặn ngay Casim lại, rồi sau đó chúng giết Casim.','https://truyencotich.vn/wp-content/uploads/2012/10/ali-baba.jpg',1)";
    private String SQLQuery88 = "INSERT INTO truyen VALUES (null,'Cô bé quàng khăn đỏ',' Ngày xửa, ngày xưa, có một cô bé thường hay quàng chiếc khăn màu đỏ, vì vậy, mọi người gọi cô là cô bé quàng khăn đỏ. Một hôm, mẹ cô bảo cô mang bánh sang biếu bà ngoại. Trước khi đi, mẹ cô dặn:\n" +
            "\n" +
            "– Con đi thì đi đường thẳng, đừng đi đường vòng qua rừng mà chó sói ăn thịt con đấy. Trên đường đi, cô thấy đường vòng qua rừng có nhiều hoa, nhiều bướm, không nghe lời mẹ dặn, cô tung tăng đi theo đường đó. Đi được một quãng thì gặp Sóc, Sóc nhắc:\n" +
            "\n" +
            "– Cô bé quàng khăn đỏ ơi, lúc nãy tôi nghe mẹ cô dặn đi đường thẳng, đừng đi đường vòng cơ mà. Sao cô lại đi đường này?\n" +
            "\n" +
            "Cô bé không trả lời Sóc. Cô cứ đi theo đường vòng qua rừng. Vừa đi, cô vừa hái hoa, bắt bướm. Vào đến cửa rừng thì cô gặp chó sói. Con chó sói rất to đến trước mặt cô. Nó cất giọng ồm ồm hỏi:\n" +
            "\n" +
            "– Này, cô bé đi đâu thế?\n" +
            "\n" +
            "Nghe chó sói hỏi, cô bé quàng khăn đỏ sợ lắm, nhưng cũng đành bạo dạn trả lời:\n" +
            "\n" +
            "– Tôi đi sang nhà bà ngoại tôi.\n" +
            "\n" +
            "Nghe cô bé nói đi sang bà ngoại, chó sói nghĩ bụng: À, thì ra nó lại còn có bà ngoại nữa, thế thì mình phải ăn thịt cả hai bà cháu. Nghĩ vậy nên chó sói lại hỏi:\n" +
            "\n" +
            "– Nhà bà ngoại cô ở đâu?\n" +
            "\n" +
            "– Ở bên kia khu rừng. Cái nhà có ống khói đấy, cứ đẩy cửa là vào được ngay.\n" +
            "\n" +
            "Nghe xong, chó sói bỏ cô bé quàng khăn đỏ ở đấy rồi chạy một mạch đến nhà bà ngoại cô bé. Nó đẩy cửa vào vồ lấy bà cụ rồi nuốt chửng ngay vào bụng. Xong xuôi, nó lên giường nằm đắp chăn giả là bà ngoại ốm.\n" +
            "\n" +
            "Lúc cô bé quàng khăn đỏ đến, cô thấy chó sói đắp chăn nằm trên giường, cô tưởng “bà ngoại” bị ốm thật, cô hỏi:\n" +
            "\n" +
            "– Bà ơi! Bà ốm đã lâu chưa?\n" +
            "\n" +
            "Sói không đáp giả vờ rên hừ… hừ…\n" +
            "\n" +
            "– Bà ơi, mẹ cháu bảo mang bánh sang biếu bà.\n" +
            "\n" +
            "– Thế à, thế thì bà cám ơn cháu và mẹ cháu. Cháu ngoan quá. Cháu lại đây với bà.\n" +
            "\n" +
            "\n" +
            "Cô bé quàng khăn đỏ chạy ngay đến cạnh giường, nhưng cô ngạc nhiên lùi lại hỏi;\n" +
            "\n" +
            "– Bà ơi! Sao hôm nay tai bà dài thế?\n" +
            "\n" +
            "– Tai bà dài để bà nghe cháu nói được rõ hơn. Chó sói đáp\n" +
            "\n" +
            "– Thế còn mắt bà, sao hôm nay mắt bà to thế?\n" +
            "\n" +
            "– Mắt bà to để bà nhìn cháu được rõ hơn.\n" +
            "\n" +
            "Chưa tin, cô bé quàng khăn đỏ lại hỏi:\n" +
            "\n" +
            "– Thế còn mồm bà, sao hôm nay mồm bà to thế?\n" +
            "\n" +
            "– Mồm bà to để bà ăn thịt cháu đấy.\n" +
            "\n" +
            "Sói nói xong liền nhảy ra khỏi giường, nuốt chửng em bé Khăn Đỏ đáng thương.\n" +
            "\n" +
            "Sói đã no nê lại nằm xuống giường ngủ ngáy o o. May sao, lúc đó bác thợ săn đi ngang thấy thế. Bác giơ súng lên định bắn. Nhưng bác chợt nghĩ ra là chắc sói đã ăn thịt bà lão, và tuy vậy vẫn còn có cơ cứu bà. Bác nghĩ không nên bắn mà nên lấy kéo rạch bụng con sói đang ngủ ra. Vừa rạch được vài mũi thì thấy chiếc khăn quàng đỏ chóe, rạch được vài mũi nữa thì cô bé nhảy ra kêu:\n" +
            "\n" +
            "– Trời ơi! Cháu sợ quá! Trong bụng sói, tối đen như mực. Bà lão cũng còn sống chui ra, thở hổn hển. Khăn đỏ vội đi nhặt đá to nhét đầy bụng sói. Sói tỉnh giấc muốn nhảy lên, nhưng đá nặng quá, nó ngã khuỵu xuống, lăn ra chết.\n" +
            "\n" +
            "Từ dạo ấy, cô bé quàng khăn đỏ không bao giờ dám làm sai lời mẹ dặn.','https://truyencotich.vn/wp-content/uploads/2012/10/1b5-660x440.jpg',1)";
    private String SQLQuery888 = "INSERT INTO truyen VALUES (null,'Nàng công chúa chăn ngỗng','Ngày xưa có một bà hoàng hậu tuổi đã cao. Đức vua chết đã lâu. Bà có một cô con gái rất xinh đẹp. Khi lớn lên, nàng được hứa hôn với một chàng Hoàng tử con vua một nước xa xôi.\n" +
            "\n" +
            "Đến ngày tổ chức lễ cưới, nàng công chúa sửa soạn đi đến nước xa lạ. Mẹ nàng gói ghém cho nàng những vật quí giá: đồ trang sức, vàng, bạc, cốc, châu ngọc, tóm lại là tất cả những gì xứng đáng làm của hồi môn cho một công chúa, vì mẹ nàng rất mực thương nàng. Mẹ nàng gửi gắm nàng cho một thị nữ có nhiệm vụ dẫn nàng đi đến chỗ ở người chồng chưa cưới. Mỗi người cưỡi một con ngựa. Ngựa công chúa cưỡi tên là Phalađa, biết nói.\n" +
            "\n" +
            "Đến lúc chia tay, bà hoàng vào trong phòng ngủ, lấy một con dao nhỏ trích ngón tay, để chảy ba giọt máu. Bà cho máu thấm xuống một cái khăn trắng nhỏ, đưa cho cô gái và dặn: “Con thân yêu, con hãy giữ gìn cẩn thận cái khăn này, nó sẽ có ích cho con trên đường đi”.\n" +
            "\n" +
            "Hai mẹ con buồn bã từ biệt nhau. Công chúa áp cái khăn lên ngực, nhảy lên yên ngựa để đi đến nơi ở của người yêu. Sau khi đã đi một tiếng, cô cảm thấy khát khô họng, bèn bảo thị nữ:\n" +
            "\n" +
            "– “Em hãy xuống ngựa, lấy cốc của ta múc nước suối kia và mang lại đây cho ta, ta khát nước lắm”.\n" +
            "\n" +
            "– “Nếu cô khát, thị nữ trả lời, thì hãy tự nhảy xuống, rồi vươn người ra trên mặt nước mà uống. Tôi không phải là đầy tớ của cô”.\n" +
            "\n" +
            "Công chúa khát lắm, bèn xuống ngựa, cúi xuống dòng nước suối để uống nước. Nàng không dám uống nước bằng cốc vàng. “Trời ơi!” nàng kêu to. Ba giọt máu bảo cô: “Nếu mẹ cô biết sự tình thế này, thì hẳn tim bà sẽ tan nát trong ngực”.\n" +
            "\n" +
            "Nhưng công chúa là người can đảm. Nàng không nói gì và lại nhảy lên ngựa. Ngựa phi được vài dặm. Trời thì nóng nực, chẳng mấy chốc nàng lại khát nước.\n" +
            "\n" +
            "Tới một con sông, nàng bảo thị nữ: “Em hãy xuống ngựa và cho ta uống nước bằng cái cốc vàng”. Cô đã quên đứt những lời độc ác của thị nữ. Nhưng thị nữ lại trả lời ngạo mạn hơn: “Nếu cô khát thì tự đi uống nước một mình, tôi không phải là đầy tớ của cô”.\n" +
            "\n" +
            "Công chúa khát quá, nhảy xuống ngựa, cúi xuống dòng nước chảy xiết, khóc và kêu lên: “Trời ơi!” Ba giọt máu liền đáp lại: “Nếu mẹ cô biết sự tình thế này, thì hẳn tim bà tan nát trong ngực”. Trong khi cô cúi xuống để uống thì cái khăn có thấm ba giọt máu, tuột khỏi ngực cô và trôi theo dòng nước mà cô không hay biết, vì lúc đó cô rất sợ hãi.\n" +
            "\n" +
            "Thị nữ thì lại trông thấy hết và nó rất vui mừng từ giờ trở đi công chúa sẽ bị nó trả thù. Từ lúc đánh mất ba giọt máu, công chúa trở nên yếu đuối, không đủ sức tự vệ nữa. Khi nàng định trèo lên con ngựa Phalađa thì thị nữ bảo: “Tôi sẽ cưỡi con Phalađa, còn cô, cô hãy cưỡi con ngựa tồi của tôi”.\n" +
            "\n" +
            "Công chúa đành làm như vậy. Tiếp đó thị nữ ra lệnh, lời lẽ gay gắt, bắt nàng phải cởi quần áo hoàng cung ra và mặc quần áo của nó vào. Cô lại phải thề với trời đất là khi đến cung điện sẽ không nói lộ ra. Nếu cô không chịu thề thì nó sẽ giết cô tại chỗ. Nhưng con Phalađa đã quan sát tất cả và ghi nhớ tất cả. Thị nữ cưỡi con Phalađa, còn công chúa thì cưỡi con ngựa tồi. Nó lại tiếp tục đi, cuối cùng đến lâu đài nhà vua. Ở đấy, mọi người rất vui mừng khi họ tới, và Hoàng tử vội chạy tới tận nơi đón họ, đỡ thị nữ xuống ngựa, vì tưởng rằng đó là vợ chưa cưới của mình. Thị nữ đi lên bậc thềm lâu đài, còn nàng công chúa thì phải đứng lại ngoài sân.\n" +
            "\n" +
            "Vua cha nhìn ra, qua cửa sổ thấy nàng duyên dáng và tuyệt đẹp. Người vào trong cung hỏi cô gái được coi là vợ chưa cưới của Hoàng tử xem cô gái đứng ngoài sân là ai. “Tâu vua cha, con đã gặp cô gái đó trên đường đi và con đưa cô ta đi cùng để đỡ lẻ loi một mình. Xin vua cha cho cô ta làm việc để cô ta khỏi phải vô công rồi nghề”. Nhưng vua cha không có việc gì giao cho cô làm cả.\n" +
            "\n" +
            "Người bảo: “Ở ngoài kia, ta có một anh chàng chăn ngỗng, hãy để cô ta giúp việc vậy”. Chàng trai tên là Cuốc. Vợ chưa cưới của Hoàng tử phải giúp anh chăn ngỗng.\n" +
            "\n" +
            "Ít lâu sau, vợ chưa cưới giả tâu với hoàng tử: “Chàng thân yêu ơi, em muốn một điều, chàng hãy làm vui lòng em”. Hoàng tử nói: “Được thôi!” “Chàng hãy cho gọi người thợ lột da đến đập chết con ngựa em đang cưỡi đến đây, vì trong khi đi đường nó làm em bực tức”.\n" +
            "\n" +
            "Thật ra thì nó sợ con ngựa kể lại cách nó đã đối xử với công chúa. Đến lúc con ngựa trung thành Phalađa phải chết thì công chúa được tin. Nàng hứa với người thợ lột da là sẽ bí mật biếu anh một đồng tiền bằng bạc nếu anh giúp nàng một việc nhỏ. Trong đô thị có một cái cổng to rất tối, hàng ngày, sớm tối nàng phải dẫn đàn ngỗng đi qua. Nàng xin người thợ lột da hãy đóng đanh treo đầu con Phalađa vào cái cổng ấy để nàng có thể luôn luôn trông thấy nó.\n" +
            "\n" +
            "Người thợ lột da hứa sẽ làm và bác đóng chặt đanh treo đầu ngựa vào dưới cái cổng tối om. Sáng sớm, khi cùng Cuốc đi qua cổng, cô bảo cái đầu: “Ôi, Phalađa, mày bị treo ở đây ư!” Cái đầu trả lời: “Ôi! Nàng công chúa của tôi, nàng qua đây ư! Nếu mẹ nàng biết nông nỗi này tim mẹ sẽ vỡ tan tành”. Lặng lẽ, cô đi khỏi đô thị, dẫn đàn ngỗng ra cánh đồng.\n" +
            "\n" +
            "Đến đồng cỏ, cô ngồi xuống và rũ tóc ra. Tóc cô óng ánh như vàng nguyên chất và Cuốc rất thích nhìn mớ tóc ấy lóe sáng. Anh muốn nhổ vài sợi tóc. Công chúa bèn nói: “Ta khóc đây, ta khóc đây! Hỡi làn gió nhẹ. Hãy cuốn cái mũ của Cuốc đi! Anh ta sẽ chạy theo cái mũ cho đến khi nào tóc ta chải và tết xong”. Tức thì gió thổi mạnh cuốn đi cái mũ của Cuốc. Anh ta chạy theo ngay. Khi anh trở về thì công chúa đã chải đầu xong và anh không nhổ được sợi tóc nào. Anh rất bực và không nói năng gì với cô nữa.\n" +
            "\n" +
            "Họ lại tiếp tục chăn ngỗng đến chiều, rồi cùng về nhà. Sáng sớm hôm sau, khi lùa ngỗng qua cổng, cô gái nói: “Ôi, Phalađa, mày bị treo ở đây ư!”\n" +
            "\n" +
            "Cái đầu trả lời: “Ôi! Nàng công chúa của tôi, nàng qua đây ư! Nếu mẹ nàng biết nông nỗi này, tim mẹ sẽ vỡ tan tành”.\n" +
            "\n" +
            "Đi ra khỏi đô thị, cô lại ngồi trên đồng cỏ và lại rũ tóc ra chải. Cuốc muốn nắm lấy mớ tóc. Cô vội vàng nói: “Ta khóc đây, ta khóc đây! Hỡi làn gió nhẹ, hãy cuốn cái mũ của Cuốc đi! Anh ta sẽ chạy theo cái mũ cho đến khi nào tóc ta chải và tết xong”. Gió nổi lên, cuốn cái mũ đi. Cuốc phải chạy theo. Khi anh trở về thì công chúa đã chải đầu xong từ lâu và anh không nắm được mớ tóc ấy. Và rồi hai người lại cùng chăn ngỗng đến chiều.\n" +
            "\n" +
            "Nhưng chiều hôm ấy, về tới nhà, Cuốc đến gặp vua cha và tâu: “Kính thưa hoàng thượng, con không thể chăn ngỗng cùng cô gái này nữa” – “Tại sao vậy?”, vua hỏi. “Suốt ngày, cô ta làm con bực mình!” – Vua cha bảo anh kể lại sự việc đã xảy ra. Cuốc nói: “Buổi sáng, chúng con dẫn đàn ngỗng qua cái cổng tối om, ở đấy có một cái đầu ngựa treo trên tường. Cô ta nói với nó: “Ôi, Phalađa, mày bị treo ở đây ư!” Cái đầu trả lời: “Ôi! Nàng công chúa của tôi, nàng qua đây ư! Nếu mẹ nàng biết nông nỗi này tim mẹ sẽ vỡ tan tành.” Và Cuốc kể các sự việc đã xảy ra ở cánh đồng chăn ngỗng và tại sao anh ta lại phải chạy theo cái mũ. Vua cha dặn anh ta ngày hôm sau cứ đi chăn ngỗng như thường lệ.\n" +
            "\n" +
            "Sáng sớm ngài thân chinh đến dưới cái cổng tối om và nghe được những câu cô gái nói với cái đầu Phalađa. Ông theo ra cánh đồng và nấp vào một bụi cây. Chính mắt ngài trông thấy anh thanh niên và cô gái lùa ngỗng thế nào và sau một lúc, cô gái ngồi xuống gỡ mớ tóc vàng lóe sáng. Rồi cô lại nói: “Ta khóc đây, ta khóc đây! Hỡi làn gió nhẹ, hãy cuốn cái mũ của Cuốc đi! Anh ta sẽ chạy theo cái mũ cho đến khi nào tóc ta chải và tết xong”. Một cơn gió thổi mạnh, cuốn cái mũ đội đầu của Cuốc đi. Anh phải chạy theo rất xa. Cô gái chăn ngỗng chải tóc và cuốn thành từng búp. Vua cha nhìn thấy tất cả. Không ai nhận ra ngài khi ngài rời khỏi đó.\n" +
            "\n" +
            "Chiều đến, cô gái về nhà, ngài cho gọi cô đến và hỏi tại sao cô lại làm như thế. “Tâu bệ hạ, con không thể nói được”, – cô trả lời. – “Con không thể kể nỗi khổ của con với bất cứ ai trên thế gian này, con đã thề như vậy để khỏi bị người ta giết”. Vua cha cô ép cô nói, nhưng ngài không biết được gì thêm bèn nói: “Nếu con không muốn nói với ta, thì con hãy kể nỗi khổ của con với cái bếp lò này”. Rồi ông bỏ đi.\n" +
            "\n" +
            "Cô đến ngồi gần cái bếp lò, than khóc, thổ lộ tâm can: “Ta ngồi đây, bị cả thế gian ruồng bỏ, dù ta là con vua. Một tên thị nữ độc ác đã áp chế ta, bắt ta đổi cho nó quần áo hoàng cung. Nó thay thế ta để làm vợ chưa cưới của người yêu ta, và ta bắt buộc phải làm công việc bình thường của người chăn ngỗng. Nếu mẹ ta biết nông nỗi này, tim bà sẽ tan nát”.\n" +
            "\n" +
            "Vua cha đứng ở phía tường bên kia gần ống thông hơi, ngài đã nghe thấy hết. Ngài trở về và gọi cô hãy rời cái lò đến gặp ngài. Người ta mang đến cho cô quần áo hoàng cung, cô mặc vào đẹp như là có phép lạ. Vua cha cho gọi con trai đến và bảo cho con biết về cô vợ chưa cưới giả mạo. Cô người yêu thật đứng trước chàng, đấy là cô gái chăn ngỗng.\n" +
            "\n" +
            "Hoàng tử thấy cô rất đẹp và phúc hậu nên lòng tràn ngập niềm vui. Một bữa tiệc được sửa soạn để mời tất cả các bạn bè thân thuộc. Hoàng tử và công chúa ngồi ở đầu bàn, trước mặt họ là con thị nữ. Nó bị choáng ngợp và không nhận ra cô chủ trang sức lộng lẫy. Khi họ đang ăn uống vui vẻ, vua cha ra một câu đố cho thị nữ. Nó phải trả lời là một người đàn bà lừa dối chủ thì sẽ bị xử tội như thế nào. Ngài kể các sự việc đã xảy ra và hỏi nó: “Như thế sẽ xứng đáng với hình phạt gì”. – “Nó xứng đáng phải đuổi đi khỏi đất nước” – “Kẻ ấy chính là mày, mày sẽ bị xử tội như mày nói”. Sau khi hình phạt được thi hành, Hoàng tử cưới nàng công chúa làm vợ và họ trị vì đất nước trong hòa bình và hạnh phúc.','https://truyencotich.vn/wp-content/uploads/2012/10/n%C3%A0ng-c%C3%B4ng-ch%C3%BAa-ch%C4%83n-ng%E1%BB%97ng-640x440.jpg',1)";
    private String SQLQuery8888 = "INSERT INTO truyen VALUES (null,'Nàng công chúa ngủ trong rừng','Ngày xưa có một ông vua và một bà hoàng hậu ngày nào cũng nói: “Ước gì mình có đứa con!” mà mãi vẫn không có. Một hôm hoàng hậu đang tắm thì có con ếch ở dưới nước nhảy lên nói:\n" +
            "\n" +
            "– Điều bà mong ước bấy lâu sẽ thành sự thực. Hết năm nay bà sẽ sinh con gái.\n" +
            "\n" +
            "Lời ếch tiên tri quả đúng thật. Hoàng hậu sinh con gái đẹp tuyệt trần.Vua thích lắm, mở hội lớn ăn mừng. Vua mời họ hàng thân thuộc, bạn bè, lại mời cả các bà mụ đến để họ tận tâm chăm sóc, thương yêu con mình.\n" +
            "\n" +
            "Trong nước có mười ba bà mụ. Nhưng vua chỉ có mười hai cái đĩa vàng để mời ăn, do đó mời thiếu một bà. Hội hè linh đình. Lúc tiệc sắp tàn, các bà mụ niệm chú mừng đứa bé những điều kỳ lạ: bà đầu chúc đức hạnh, bà thứ hai chúc sắc đẹp, bà thứ ba của cải… cứ như vậy chúc tất cả các điều có thể mơ ước được ở trần gian. Mười một bà vừa dứt lời chúc tụng thì bỗng bà mụ thứ mười ba bước vào. Bà muốn trả thù vì không được mời dự tiệc. Bà xăm xăm bước thẳng vào chẳng thèm nhìn ai, chào ai. Bà hét lên:\n" +
            "\n" +
            "– Công chúa đến năm mười lăm tuổi sẽ bị mũi quay sợi đâm phải mà chết.\n" +
            "\n" +
            "Rồi bà chẳng nói thêm nửa lời, bỏ đi. Mọi người chưa hết kinh ngạc thì bà thứ mười hai bước lên. Bà tuy chưa niệm chú chúc tụng nhưng cũng không giải được lời chú độc, mà chỉ làm nhẹ đi được thôi. Bà nói:\n" +
            "\n" +
            "– Công chúa sẽ không chết, chỉ ngủ một giấc dài trăm năm thôi.\n" +
            "\n" +
            "Vua muốn tránh cho con khỏi bị nạn ra lệnh cấm kéo sợi trong cả nước. Tất cả những lời chúc của các bà mụ đều thành sự thực: công chúa đẹp, đức hạnh, nhã nhặn, thông minh, ai thấy cũng phải yêu.\n" +
            "\n" +
            "Năm ấy, công chúa vừa đúng mười lăm tuổi. Một hôm, vua và hoàng hậu đi vắng, nàng ở nhà một mình. Nàng đi khắp cung điện để xem tất cả các buồng, thích đâu tạt vào đó. Sau cùng nàng tới một lầu cao. Nàng trèo lên chiếc thang xoáy ốc chật hẹp, tới một cửa nhỏ. Ổ khóa có cắm một chiếc chìa đã gỉ, nàng cầm chìa quay thì cửa mở tung ra. Trong buồng có một bà già ngồi trên tấm ghế nhỏ đang chăm chú kéo sợi. Nàng nói:\n" +
            "\n" +
            "– Chào bà. Bà làm gì đấy?\n" +
            "\n" +
            "Bà lão gật gù đáp:\n" +
            "\n" +
            "– Bà kéo sợi đay.\n" +
            "\n" +
            "– Cái gì nhảy nhanh như cắt thế kia hở bà?\n" +
            "\n" +
            "Nàng cầm lấy xa định kéo sợi. Vừa sờ đến thì lời chú thực hiện, nàng bị mũi quay đâm vào tay.\n" +
            "Nàng ngã ngay xuống giường và ngủ mê mệt. Tất cả cung điện đều ngủ. Vua và hoàng hậu vừa về, mới bước chân vào buồng đã nhắm mắt ngủ. Cả triều đình cũng lăn ra ngủ. Ngựa trong chuồng, chó ngoài sân, bồ câu trên mái nhà, ruồi trên tường, đều ngủ. Cả ngọn lửa đang chập chờn trên bếp cũng ngủ yên. Thịt quay cũng ngừng xèo xèo. Bác đầu bếp thấy chú phụ bếp đãng trí đang kéo tóc chú cũng buông ra ngủ. Gió lặng yên trên cây trước lâu đài, không một chiếc lá nào rung. Bụi gai mọc quanh mỗi ngày một rậm, phủ kín cả lâu đài, trong miền ấy, nhân dân truyền tụng là có Đóa Hồng xinh đẹp đương ngủ triền miên. Người ta gọi công chúa là Đóa Hồng. Thỉnh thoảng các Hoàng tử nghe kể chuyện định chui qua bụi vào lâu đài nhưng không nổi vì bụi gai như có tay, nắm chặt họ lại khiến họ bị mắc nghẽn.\n" +
            "\n" +
            "Năm tháng trôi qua đã nhiều. Một hôm lại có một Hoàng tử tới nước này. Chàng nghe một ông lão kể lại là trong tòa lâu đài sau bụi gai có nàng công chúa tên là Đóa Hồng ngủ triền miên đã được trăm năm. Vua, hoàng hậu và cả triều đình cũng đều ngủ cả. Ông lão còn bảo là theo lời tổ phụ để lại thì đã có nhiều Hoàng tử tìm cách chui qua bụi rậm nhưng bị mắc lại ở đấy. Chàng liền bảo:\n" +
            "\n" +
            "– Tôi không sợ, tôi muốn chui vào tìm nàng Đóa Hồng xinh đẹp.\n" +
            "\n" +
            "Ông lão hết sức can ngăn, chàng nhất định không nghe. Thời hạn trăm năm đã qua. Đã đến lúc Đóa Hồng tỉnh giấc. Hoàng tử đến gần bụi gai thì chỉ thấy toàn những đóa hoa to tươi\n" +
            "đẹp tự động giãn lối để chàng khỏi bị thương. Chàng đi rồi thì bụi cây khép lại. Ở sân lâu đài, chàng thấy ngựa và những con chó lốm đốm đang nằm ngủ. Chim bồ câu rũ đầu vào cánh đậu trên mái nhà. Chàng vào cung thì thấy ruồi bậu trên tường ngủ, bác đầu bếp còn giơ tay như định tóm lấy chú phụ bếp. Còn cô hầu gái thì đương ngồi làm lông con gà đen. Chàng đi vào cung điện chính thì thấy cả triều đình đều ngủ. Chàng lại tiếp tục đi. Im lặng như tờ. Có thể nghe thấy hơi thở của chàng. Sau chàng tới một tòa lầu, mở cửa vào một phòng nhỏ là nơi Đóa Hồng đang ngủ. Nàng nằm trông đẹp lộng lẫy. Chàng không rời mắt ra được, quì xuống hôn.\n" +
            "\n" +
            "Chàng vừa đụng môi thì Đóa Hồng mở mắt, nhìn chàng trìu mến. Hai người dắt nhau xuống lầu. Vua, rồi hoàng hậu và cả triều đình đều tỉnh dậy, giương mắt nhìn nhau. Ngựa ngoài sân đứng lên quẫy mình; chó săn nhảy lên ngoe nguẩy đuôi; bồ câu trên mái nhà vươn cổ ngóc đầu nhìn quanh rồi bay qua cánh đồng; ruồi bậu trên tường lại tiếp tục bò; lửa trong bếp bùng lên, chập chờn và đun thức ăn, thịt quay lại xèo xèo, bác đầu bếp tát chú phụ bếp một cái bạt tai làm hắn kêu lên, các cô hầu làm nốt lông gà.\n" +
            "\n" +
            "Lễ cưới của Hoàng tử và nàng Đóa Hồng được tổ chức linh đình. Hai vợ chồng sống suốt đời sung sướng. Nàng công chúa được Hoàng Tử đánh thức sau giấc ngủ một trăm năm. Lời nguyền độc ác của bà mụ thứ mười ba bị hóa giải, nàng xứng đáng được hưởng hạnh phúc.','https://truyencotich.vn/wp-content/uploads/2012/10/335550.jpg',1)";
    private String SQLQuery88888 = "INSERT INTO truyen VALUES (null,'Hênxen và Grêten','Ngày xưa có hai vợ chồng một bác tiều phu nghèo khó, sống ở ven một khu rừng lớn. Gia đình có hai con. Con trai tên là Hênxen, con gái tên là Grêten. Nhà không đủ ăn. Một năm, trời làm đói kém, miếng bánh hàng ngày cũng chẳng có. Tối hôm ấy, chồng nằm trằn trọc mãi, thở dài bảo vợ:\n" +
            "\n" +
            "– Chả biết rồi sao đây? Lương thực cạn rồi, lấy gì nuôi con?\n" +
            "\n" +
            "Đói khổ khiến người mẹ đâm ra nhẫn tâm. Hết đường xoay xở, vợ bảo chồng:\n" +
            "\n" +
            "– Thầy nó ạ, biết sao đây! Ngày mai, sớm tinh mơ, tôi với nhà đưa chúng vào rừng rậm, đốt lửa lên, cho mỗi đứa một mẩu bánh rồi bỏ chúng đấy mà đi làm. Chúng không biết đường mà về, thế là rảnh.\n" +
            "\n" +
            "Chồng đáp:\n" +
            "\n" +
            "– Nhà nó ạ, tôi chịu không làm thế được đâu. Nỡ nào đem bỏ con vào rừng cho thú đói ăn thịt!\n" +
            "\n" +
            "– Thầy nó thật là điên. Không làm thế thì chết đói cả bốn mạng, chỉ còn việc bào gỗ đóng săng mà thôi.\n" +
            "\n" +
            "Người vợ lèo nhèo mãi, kỳ đến lúc chồng phải làm theo ý mình.\n" +
            "\n" +
            "Chồng nói:\n" +
            "\n" +
            "– Nhưng tôi vẫn thương xót chúng nó lắm!\n" +
            "\n" +
            "Hai đứa trẻ đói quá không ngủ được, nghe được hết. Grêten khóc sướt mướt, bảo Hênxen:\n" +
            "\n" +
            "– Anh em mình chết đến nơi rồi.\n" +
            "\n" +
            "Hênxen đáp:\n" +
            "\n" +
            "– Em đừng lo buồn, anh sẽ có cách thoát chết.\n" +
            "\n" +
            "Chờ lúc bố mẹ ngủ rồi, nó dậy mặc áo, mở cửa, lén ra ngoài. Trăng sáng. Sỏi trắng ở trước nhà lóng lánh như bạc. Hênxen nhặt sỏi bỏ đầy túi áo, rồi về nhà bảo Grêten:\n" +
            "\n" +
            "– Em ơi, cứ yên trí mà ngủ đi.\n" +
            "\n" +
            "Rồi nó lại đi ngủ.\n" +
            "\n" +
            "Tang tảng sáng, mặt trời chưa mọc thì mẹ đã đến đánh thức hai con:\n" +
            "\n" +
            "– Đồ lười! Dậy đi, còn phải vào rừng lấy củi chứ!\n" +
            "\n" +
            "Rồi mẹ đưa cho mỗi con một mẩu bánh dặn:\n" +
            "\n" +
            "– Chúng mày cầm lấy mà ăn trưa. Chớ có ăn nghiến ngấu\n" +
            "trước, không còn nữa mà cho đâu.\n" +
            "\n" +
            "Grêten bỏ bánh vào túi áo và Hênxen đã bỏ đá đầy túi rồi. Cả nhà cùng nhau đi vào rừng.\n" +
            "\n" +
            "Đi được một lát, Hênxen chốc chốc lại dừng lại ngoảnh về mé nhà. Bố thấy vậy bảo:\n" +
            "\n" +
            "– Hênxen, sao mày cứ lùi lại nhìn gì mãi thế? Liệu đấy, đừng có dềnh dàng.\n" +
            "\n" +
            "Hênxen đáp:\n" +
            "\n" +
            "– Con nhìn con mèo trắng của nhà ngồi trên mái từ biệt con đấy.\n" +
            "\n" +
            "Mẹ nói:\n" +
            "\n" +
            "– Đồ ngốc! Không phải con mèo đâu, đấy là ống khói phản chiếu ánh mặt trời đấy.\n" +
            "\n" +
            "Hênxen lùi lại không phải để nhìn mèo, mà cốt để rắc sỏi trắng ra đường.\n" +
            "\n" +
            "Khi đến giữa rừng, bố nói:\n" +
            "\n" +
            "– Chúng mày hãy đi nhặt củi, còn bố đốt lửa để chúng mày khỏi rét.\n" +
            "\n" +
            "Hênxen và Grêten đi nhặt củi khô xếp thành đống. Khi ngọn lửa đã cao, củi cháy nỏ, mẹ nói:\n" +
            "\n" +
            "– Thôi bây giờ chúng mày nằm gần lửa mà nghỉ. Tao và bố đi đẵn củi, xong sẽ quay về đón.\n" +
            "\n" +
            "Hai đứa trẻ ngồi bên lửa. Đến trưa, chúng lấy bánh ra ăn. Nghe thấy tiếng bổ vào cây, chúng tưởng bố chúng ở gần đấy. Nhưng không phải tiếng rìu của bố, mà đó chỉ là tiếng cành cây bị gió đập vào cây khô. Chúng ăn xong, mắt díp lại vì mệt, liền ngủ một giấc say. Khi chúng thức dậy thì trời đã tối như mực. Grêten khóc nói:\n" +
            "\n" +
            "– Bây giờ làm thế nào mà ra khỏi rừng được?\n" +
            "\n" +
            "Hênxen dỗ em:\n" +
            "\n" +
            "– Em cứ đợi một lát, chờ trăng lên, chúng mình sẽ tìm được lối về nhà.\n" +
            "\n" +
            "Khi trăng mọc, Hênxen cầm tay em theo vết sỏi lóng lánh như tiền mới mà lần về nhà. Chúng gõ cửa. Mẹ mở, thấy Hênxen và Grêten liền nói:\n" +
            "\n" +
            "– Đồ khốn kiếp, sao chúng mày ngủ kỹ ở trong rừng thế? Tao cứ tưởng chúng mày không muốn về nữa.\n" +
            "\n" +
            "Bố thấy con về thì mừng lắm vì trong thâm tâm bố không muốn bỏ con. Sau đó ít lâu, trời lại làm đói kém khắp nơi. Một đêm hai anh em nghe thấy mẹ nằm trên giường nói với bố:\n" +
            "\n" +
            "– Mọi thứ lại hết sạch rồi. Chỉ còn có nửa cái bánh ăn nốt là hết nhẵn. Phải tống chúng nó đi. Lần này ta đem bỏ chúng vào rừng sâu hơn trước để chúng không tìm được lối về. Bằng không thì không còn cách nào thoát.\n" +
            "\n" +
            "Người chồng không đành lòng nghĩ bụng:\n" +
            "\n" +
            "– Thà chia nhau với con ăn miếng bánh cuối cùng còn hơn.\n" +
            "\n" +
            "Vợ không nghe, chửi chồng thậm tệ, cho là đã chót thì phải trét, lần trước đã theo ý mụ thì lần này cũng phải theo. Hai đứa trẻ chưa ngủ, nghe hết những chuyện bố mẹ bàn nhau. Khi thấy bố mẹ đã ngủ rồi, Hênxen dậy định ra ngoài nhặt sỏi như lần trước. Nhưng mẹ nó đã khóa cửa mất rồi, nó không ra được. Nó dỗ em gái:\n" +
            "\n" +
            "– Em ạ, đừng khóc nữa, em cứ ngủ yên đi, anh sẽ có cách.\n" +
            "\n" +
            "Sáng sớm tinh mơ, mẹ kéo cổ chúng dậy, cho mỗi đứa một mẩu bánh bé hơn lần trước. Dọc đường đi đến rừng, Hênxen cho tay vào túi bẻ vụn bánh mì ra và chốc chốc lại dừng lại rắc bánh xuống đất.\n" +
            "\n" +
            "Bố hỏi Hênxen:\n" +
            "\n" +
            "– Sao mày cứ hay dừng chân ngoảnh lại thế? Đi đi.\n" +
            "\n" +
            "Hênxen đáp:\n" +
            "\n" +
            "– Con nhìn con chim bồ câu của con nó đậu trên mái nhà để chào con kia kìa.\n" +
            "\n" +
            "Mụ đàn bà nói:\n" +
            "\n" +
            "– Đồ ngốc, không phải là chim bồ câu đâu mà là cái ống khói có mặt trời chiếu vào đấy.\n" +
            "\n" +
            "Dù sao, dọc đường, Hênxen cũng rắc được hết bánh. Mụ đàn bà dẫn hai con vào tít chỗ rừng sâu mà từ thủa cha sinh mẹ đẻ mụ chưa tới bao giờ. Sau khi đốt lửa cháy to lên, mụ nói:\n" +
            "\n" +
            "– Chúng mày ngồi đó. Lúc nào mệt thì ngủ đi một tí. Tao với bố mày đi đẵn gỗ, chiều tối xong sẽ quay lại đón chúng mày.\n" +
            "\n" +
            "Đến trưa Grêten chia bánh cho anh vì bánh của anh đã rắc ở dọc đường rồi. Ăn xong, chúng ngủ. Tối đến, chẳng ai đến đón hai đứa bé đáng thương cả. Đêm tối như mực, hai đứa thức giấc, Hênxen dỗ em gái:\n" +
            "\n" +
            "– Em ạ, chờ cho trăng lên, trông rõ bánh anh đã rắc, thì ta lại tìm thấy đường về.\n" +
            "\n" +
            "Trăng vừa mọc lên thì hai đứa đứng dậy đi, nhưng chẳng thấy tí bánh nào vì hàng ngàn con chim trong rừng đã ăn mất cả rồi.\n" +
            "\n" +
            "Hênxen bảo em:\n" +
            "\n" +
            "– Thế nào rồi chúng ta cũng sẽ tìm được đường. Nhưng chúng không tìm ra đường. Chúng đi suốt cả đêm, suốt cả ngày hôm sau, mà không ra được khỏi rừng. Hai anh em bụng đói như cào mà chỉ nhặt được ít quả dại ở dưới đất. Chúng mệt quá, bước không nổi, nằm lăn ra ngủ dưới gốc cây. Chúng xa nhà đã ba ngày rồi.\n" +
            "\n" +
            "Chúng lại đi, đâm sâu mãi vào rừng, và nếu không gặp ai cứu giúp thì đến chết đói, chết mệt thôi. Giữa trưa, chúng thấy một con chim đẹp, trắng như tuyết đậu trên cành hót hay lắm. Chúng liền dừng lại để nghe. Chim hót xong xòe cánh bay trước mặt chúng. Chúng theo chim đến tận một túp nhà con; chim đến đậu trên mái nhà ấy. Chúng lại gần thấy nhà xây bằng bánh mì, lợp bằng bánh ngọt, cửa sổ bằng đường trắng tinh. Hênxen nói:\n" +
            "\n" +
            "– Thôi ổn rồi. Chúng ta được bữa ăn ngon đấy. Anh ăn một góc mái nhà, còn em ăn một mảnh cửa sổ, ngọt đấy.\n" +
            "\n" +
            "Hênxen giơ tay bẻ một mảnh mái nhà để nếm thử và Grêten đứng bên cửa kính nhấm nháp một mảnh. Bỗng trong nhà có tiếng người nhẹ nhàng vọng ra:\n" +
            "\n" +
            "– Ai gặm nhà ta đấy?\n" +
            "\n" +
            "Hai đứa trẻ đáp:\n" +
            "\n" +
            "– Gió đấy! Gió đấy! Con trời đấy!\n" +
            "\n" +
            "Rồi hai đứa cứ việc ăn, không e ngại gì cả. Hênxen thích ăn mái nhà, bẻ một miếng tướng, và Grêten cũng gỡ lấy cả một khung kính tròn xuống. Bỗng cửa mở, một bà lão bé nhỏ chống nạng rón rén bước ra. Hai anh em sợ rụng rời, đánh rời hết cả các thứ cầm trong tay. Bà lão lắc lư đầu, nói:\n" +
            "\n" +
            "– Các cháu yêu dấu, ai đưa các cháu đến đây? Các cháu đừng sợ, cứ vào. Ở đây với bà, bà không làm gì đâu.\n" +
            "\n" +
            "Bà lão dắt hai đứa vào, cho ăn ngon: sữa, bánh tráng đường, táo và hạnh đào. Rồi bà sửa soạn hai cái giường nhỏ xinh đẹp trắng tinh cho hai đứa trẻ ngủ. Hai đứa bé ngỡ là ở trên thiên đàng. Nhưng mụ già chỉ giả bộ tử tế ngoài mặt đó thôi. Đó là một mụ phù thủy gian ác rình bắt trẻ con nên làm nhà bằng bánh kẹo để nhử chúng. Khi thấy hai đứa bé vừa tới, mụ đã cười nham hiểm mà nói đùa:\n" +
            "\n" +
            "– Chúng mày vào tay bà rồi, có bay lên trời cũng chẳng thoát được tay bà.\n" +
            "\n" +
            "Sáng sớm, mụ dậy trước hai đứa, thấy chúng ngủ thật đáng yêu, má hồng phinh phính, mụ lẩm bẩm:\n" +
            "\n" +
            "– Thật là món ngon.\n" +
            "\n" +
            "Mụ đưa đôi tay khô héo ra nắm lấy Hênxen đem nhốt vào một cái cũi nhỏ, đóng cửa chấn song lại. Thằng bé kêu gào mãi mụ cũng mặc kệ. Rồi mụ đánh thức Grêten dậy bảo:\n" +
            "\n" +
            "– Đồ con gái lười chảy thây, đi dậy lấy nước làm một bữa ngon cho anh mày. Nó ở trong cũi kia, tao muốn nó chóng béo. Khi nào nó thực béo, tao sẽ ăn thịt.\n" +
            "\n" +
            "Grêten khóc thảm thiết, nhưng nào có ích gì, vì mụ phù thủy sai gì phải làm nấy. Hênxen được ăn thức ăn nấu nướng ngon lành còn Grêten phải ăn thừa. Sáng nào mụ già cũng lê đến bên cũi bảo Hênxen:\n" +
            "\n" +
            "– Giơ ngón tay tao xem đã béo chưa.\n" +
            "\n" +
            "Hênxen chỉ đưa cho mụ xem một cái xương nhỏ. Mắt kém, mụ tưởng đó là ngón tay thật, lấy làm lạ sao không thấy béo. Được một tháng vẫn không thấy Hênxen béo lên chút nào mụ đâm ra sốt ruột, không muốn chờ nữa. Mụ gọi Grêten:\n" +
            "\n" +
            "– Con Grêtên đâu? Nhanh lên, đem nước lại đây, thằng Hênxen dù béo hay gầy, ngày mai tao cũng cứ làm thịt đem nấu.\n" +
            "\n" +
            "Khốn nạn con bé vừa xách nước vừa khóc, nước mắt dòng dòng hai má. Nó kêu la:\n" +
            "\n" +
            "– Lạy trời phù hộ cho chúng con. Thà để thú dữ ăn thịt trong rừng thì hai anh em cũng được cùng nhau chết.\n" +
            "\n" +
            "Mụ già bảo:\n" +
            "\n" +
            "– Thôi đừng kêu khóc nữa mà vô ích.\n" +
            "\n" +
            "Mới bảnh mắt, Grêten đã phải đặt nồi, lấy nước và dóm bếp. Mụ già bảo:\n" +
            "\n" +
            "– Hãy nướng bánh trước đã. Tao đã dóm lò và nhào bột rồi.\n" +
            "\n" +
            "Mụ đẩy Grêten đáng thương tới bên lò. Ngọn lửa trong lò đã bắt đầu bốc lên. Mụ già bảo:\n" +
            "\n" +
            "– Mày bò vào lò xem đủ nóng chưa, để cho bánh vào nướng.\n" +
            "\n" +
            "Mụ định khi Grêten vào lò rồi thì đóng nắp lại, quay ăn một thể. Nhưng Grêten biết ý nói:\n" +
            "\n" +
            "– Cháu không biết làm thế nào mà vào được.\n" +
            "\n" +
            "Mụ già nói:\n" +
            "\n" +
            "– Đồ ngu như bò, lò có cửa khá rộng cơ mà. Trông đây này, tao vào cũng còn lọt nữa là mày.\n" +
            "\n" +
            "Mụ lại gần lò và thò đầu vào. Grêten liền đẩy mạnh mụ vào, đóng cửa sắt lại, rồi cài then ở ngoài. Mụ già rú lên khủng khiếp nhưng Grêten đã bỏ chạy để mặc mụ chết thiêu. Em chạy thẳng đến cũi vừa mở cửa cho anh vừa reo:\n" +
            "\n" +
            "– Anh ơi, anh em ta thoát rồi, con mụ phù thủy đã chết rồi.\n" +
            "\n" +
            "Cửa vừa mở thì Hênxen nhảy ra như con chim trong lồng được thả. Hai anh em vui mừng, ôm nhau hôn. Bây giờ chúng không còn sợ gì nữa, chúng đi xem nhà mụ già thì thấy ở xó nào cũng có những hòm đầy ngọc. Hênxen vừa ních đầy túi vừa nói:\n" +
            "\n" +
            "– Của này quí hơn sỏi.\n" +
            "\n" +
            "Còn Grêten nói:\n" +
            "\n" +
            "– Em cũng phải lấy về nhà mới được.\n" +
            "\n" +
            "Lấy đầy túi rồi, em nói:\n" +
            "\n" +
            "– Bây giờ hai anh em ta đi ra khỏi khu rừng của mụ phù thủy đi.\n" +
            "\n" +
            "Đi được vài giờ, chúng đến bên một cái đầm lớn. Hênxen nói:\n" +
            "\n" +
            "– Anh không thấy có cầu, qua sao được?\n" +
            "\n" +
            "Grêten bảo:\n" +
            "\n" +
            "– Một chiếc thuyền nhỏ cũng chẳng có. Nhưng kia có vịt trắng đang bơi, để em nhờ nó giúp.\n" +
            "\n" +
            "Rồi em bảo vịt rằng:\n" +
            "\n" +
            "– Vịt ơi vịt, Grêten và Hênxen đây. Kè chẳng có, cầu cũng không. Hãy cõng anh em tôi qua với.\n" +
            "\n" +
            "Vịt đến. Hênxen cưỡi lên lưng vịt và bảo em lên ngồi cạnh\n" +
            "mình. Em đáp:\n" +
            "\n" +
            "– Thôi anh ạ, ngồi thế nặng quá. Để vịt cõng từng người một.\n" +
            "\n" +
            "Vịt tốt bụng cõng làm hai chuyến. Đến bờ bên kia, hai anh em nhận dần ra đường lối trong rừng quen thuộc, và nhìn thấy nhà ở đằng xa. Chúng liền chạy ba chân bốn cẳng, nhảy bổ vào nhà, ôm ghì lấy cổ bố mẹ. Từ ngày bỏ con trong rừng, bố mẹ không lúc nào vui. Grêten dốc túi ngọc xuống đất và Hênxen thò tay vào túi lấy ra từng nắm ngọc. Từ đó, cả nhà hết lo và cùng nhau sống một cuộc đời hạnh phúc.','https://truyencotich.vn/wp-content/uploads/2012/10/Step-Brothers-Miranda-Dressler-2-660x440.jpeg',1)";
    private String SQLQuery001 = "INSERT INTO truyen VALUES (null,'Cậu bé và cây táo','Ngày xửa ngày xưa, có một cậu bé hàng ngày cậu rất thích đến chơi với một cây táo rất to. Cậu leo lên cây để hái trái ăn, ngủ những giấc trưa ngon lành dưới bóng râm của cây. Cậu rất yêu quý cây táo và ngược lại cây táo cũng rất quý mến cậu.\n" +
            "\n" +
            "Thời gian cứ thế trôi đi rất nhanh, cậu bé giờ đã lớn và cậu không còn lui tới chơi với cây táo nữa. Rồi một ngày nọ, cậu đi tới chỗ cây táo với một nét mặt buồn rầu. Cây táo reo lên gọi cậu:\n" +
            "\n" +
            "– Hãy tới chơi với ta.\n" +
            "\n" +
            "Cậu bé đáp:\n" +
            "\n" +
            "– Cháu giờ đã lớn rồi, không còn là đứa trẻ năm xưa nữa, cháu chẳng thích chơi dưới gốc cây nữa. Cháu giờ chỉ thích chơi đồ chơi và hiện giờ cháu đang cần tiền để mua chúng.\n" +
            "\n" +
            "Cây táo nói với cậu bé:\n" +
            "\n" +
            "– Rất tiếc ta chỉ có những trái táo ngọt, ta không có tiền. Nhưng cậu có thể hái những trái táo chín mọng của ta đem đi bán đổi lấy tiền mua đồ chơi.\n" +
            "\n" +
            "Cậu bé mừng rỡ, cậu trèo lên cây hái toàn bộ số táo trên cây và sung sướng đem đi bán. Cây táo rất buồn bã vì kể từ hôm đó không thấy cậu bé quay trở lại.\n" +
            "\n" +
            "Một hôm, cậu bé – giờ đã lớn thành một chàng trai, cậu trở lại và cây táo thấy rất vui mừng khi nhìn thấy cậu. Cây nói:\n" +
            "\n" +
            "– Hãy tới chơi với ta\n" +
            "\n" +
            "Cậu đáp:\n" +
            "\n" +
            "– Cháu giờ không có thời gian đâu để vui chơi. Cháu còn phải làm việc để kiếm tiền nuôi sống gia đình cháu. Gia đình cháu hiện giờ đang rất cần một ngôi nhà nhỏ để trú ngụ. Bác có gì để giúp đỡ cháu không?\n" +
            "\n" +
            "Câu táo nói với cậu:\n" +
            "\n" +
            "– Ta xin lỗi cháu, ta thì không có tiền mà cũng chẳng có nhà. Nhưng cháu có thể chặt cành của ta để dựng nhà.\n" +
            "\n" +
            "Thế là chàng trai cầm rìu tới chặt hết cành trên cây táo. Cậu vui vẻ trở gỗ về dựng nhà và cũng kể từ hôm đó cây táo lại không thấy cậu quay trở lại nữa, cây táo rất buồn.\n" +
            "\n" +
            "Một ngày hè oi bức và nóng nực, chàng trai – giờ đây đã cao tuổi – quay lại chỗ cây táo. Cây táo thấy chàng trai mừng rỡ gọi:\n" +
            "\n" +
            "– Hãy tới chơi với ta\n" +
            "\n" +
            "Chàng trai ủ rũ nói với cây táo:\n" +
            "\n" +
            "– Cháu cảm thấy rất buồn vì càng ngày cháu càng già đi. Cháu muốn được chèo thuyền để thư giãn một mình. Bác có thể giúp gì được cho cháu?\n" +
            "\n" +
            "Cây táo đáp:\n" +
            "\n" +
            "– Ta thì không có thuyền, nhưng cậu có thể dùng thân cây của ta đóng lấy một chiếc thuyền để một mình chèo thuyền ra xa. Được thư giãn nghỉ ngơi trên thuyền một mình giữa sông nước chắc cậu sẽ thấy nhẹ nhõm và thanh thản hơn.\n" +
            "\n" +
            "Chàng trai chặt cây táo để làm thành một chiếc thuyền. Cậu chèo thuyền lênh đênh giữa sông để nghỉ ngơi thư thái.\n" +
            "\n" +
            "Nhiều năm sau, cậu quay lại chỗ cây táo. Thấy cậu tới cây táo nói:\n" +
            "\n" +
            "– Xin lỗi con trai của ta, giờ đây ta không còn gì để giúp con nữa rồi. Ta giờ chỉ là một cái gốc, không có thân cũng chẳng có táo. Ta thật sự không giúp được gì cho cậu nữa, cái còn lại duy nhất của ta là bộ rễ đang chết dần chết mòn – Cây táo nói với cậu, những giọt nước mắt rưng rưng chảy xuống.\n" +
            "\n" +
            "Cậu bé đáp:\n" +
            "\n" +
            "– Giờ đây cháu cũng đã già, cháu không còn đủ sức để leo trèo nữa, cũng không còn răng để mà ăn táo. Cháu chỉ cần một chỗ để ngồi nghỉ, vì cháu đã quá mệt mỏi với những năm tháng vất vả đã qua.\n" +
            "\n" +
            "Cây táo nói với cậu:\n" +
            "\n" +
            "– Ôi, vậy cái gốc cây già cỗi này của ta là một nơi rất tốt cho cậu dựa vào và nghỉ ngơi. Hãy tới đây với ta.\n" +
            "\n" +
            "Chàng trai ngồi xuống gốc gây già cỗi, cây táo mừng rơi nước mắt.\n" +
            "\n" +
            "Đây chính là cậu chuyện của tất cả chúng ta. Hình ảnh cây táo trong truyện chính là hình ảnh của cha mẹ. Khi chúng ta còn nhỏ, ta được cha mẹ yêu thương che trở. Khi chúng ta lớn lên, ta bỏ cha mẹ mà đi và chỉ quay trở về khi cần sự giúp đỡ của cha mẹ. Nhưng lúc nào cũng vậy, vòng tay của cha mẹ luôn sẵn sàng ôm chúng ta vào lòng nâng đỡ hy sinh tất cả để cho ta được hạnh phúc nhất.','https://truyencotich.vn/wp-content/uploads/2015/09/c%E1%BA%ADu-b%C3%A9-v%C3%A0-c%C3%A2y-t%C3%A1o-640x440.jpg',1)";
    private String SQLQuery002 = "INSERT INTO truyen VALUES (null,'Mười hai người thợ săn','Ngày xưa có một vị Hoàng tử yêu vợ chưa cưới tha thiết. Một hôm, chàng đang ngồi bên nàng rất đỗi sung sướng thì nhận được tin cha ốm sắp chết muốn gặp mặt chàng trước khi nhắm mắt. Chàng liền bảo người yêu:\n" +
            "\n" +
            "– Anh phải từ biệt em đi ngay. Anh tặng em chiếc nhẫn này làm kỷ niệm. Mai sau anh lên ngôi vua rồi, anh sẽ trở lại đón em.\n" +
            "\n" +
            "Chàng lên ngựa ra đi. Khi chàng về gặp vua cha thì vua ốm thập tử nhất sinh sắp chết đến nơi. Vua cha phán:\n" +
            "\n" +
            "– Con yêu dấu ạ. Cha muốn nhìn mặt con một lần cuối cùng trước khi chết. Con phải hứa với cha là sau khi cha chết đi, con sẽ lấy vợ theo ý muốn của cha.\n" +
            "\n" +
            "Rồi vua cho chàng biết tên một nàng công chúa mà chàng phải lấy làm vợ. Trong lúc choáng váng cả người, Hoàng tử không suy nghĩ gì, chỉ thưa:\n" +
            "\n" +
            "– Thưa cha, con sẽ làm theo như ý cha.\n" +
            "\n" +
            "Nhà vua, nhắm mắt từ trần. Hoàng tử lên ngôi vua. Hết thời gian tang lễ chàng phải giữ lời\n" +
            "hứa với cha cho đi hỏi nàng công chúa ấy và được nàng nhận lời. Người vợ chưa cưới đầu tiên của chàng được tin đó buồn bao vì bị phụ tình ốm suýt chết. Cha nàng liền hỏi nàng:\n" +
            "\n" +
            "– Con yêu dấu, làm sao con buồn rầu thế? Con ước muốn gì, cha cũng cho.\n" +
            "\n" +
            "Nàng nghĩ một lúc rồi nói:\n" +
            "\n" +
            "– Thưa cha, con mong ước có mười một thiếu nữ từ mặt mũi, hình dáng, vóc người đều giống con y hệt.\n" +
            "\n" +
            "Vua cha nói:\n" +
            "\n" +
            "– Nếu là điều có thể làm được thì điều ước của con nhất định sẽ thành sự thật.\n" +
            "\n" +
            "Vua sai người đi tìm trong khắp nước kỳ cho đến khi được đủ mười một thiếu nữ giống con gái mình y hệt, từ mặt mũi hình dáng, đến khổ người. Khi các thiếu nữ có đến trước công chúa, nàng cho may mười hai bộ quần áo đi săn y hệt nhau, cho mười một cô mặc vào, chính nàng cũng mặc một bộ. Sau đó, nàng từ biệt vua cha, cùng họ lên ngựa đi đến triều đình của người chồng chưa cưới cũ mà nàng đã yêu tha thiết. Nàng đến hỏi xem nhà vua có cần thợ săn và có muốn mượn cả mười hai người không? Vua nhìn nàng nhưng không nhận ra được. Vua thấy họ đẹp quá nên đồng ý mượn cả. Thế là họ thành mười hai người thợ săn của nhà vua.\n" +
            "\n" +
            "Nhà vua vốn có một con sư tử. Đó là con vật kỳ lạ biết hết mọi điều bí ẩn. Một buổi tối nó nói với nhà vua:\n" +
            "\n" +
            "– Bệ hạ đinh ninh là có mười hai người thợ săn phải không?\n" +
            "\n" +
            "Vua bảo:\n" +
            "\n" +
            "– Đúng, đó là mười hai người thợ săn.\n" +
            "\n" +
            "Sư tử lại nói tiếp:\n" +
            "\n" +
            "– Bệ hạ lầm rồi, đó là mười hai thiếu nữ đấy.\n" +
            "\n" +
            "Vua đáp:\n" +
            "\n" +
            "– Nhất định không đúng. Người làm thế nào chứng minh được việc ấy!\n" +
            "\n" +
            "Sư tử đáp:\n" +
            "\n" +
            "– Ồ dễ thôi, bệ hạ chỉ việc rải đỗ vào phòng thì biết ngay. Đàn ông bước mạnh nên khi giẫm lên đỗ thì không hạt nào động đậy, nhưng phụ nữ bước thì thoăn thoắt lại hay xoay chân, hạt đỗ sẽ lăn đi.\n" +
            "\n" +
            "Vua khen là kế hay, cho rắc hạt đỗ. Nhưng có người hầu nhà vua có lòng tốt đối với những người thợ săn, nghe thấy nói nhà vua nhất định thử họ, liều đi kể cho biết hết và bảo:\n" +
            "\n" +
            "– Sư tử nó muốn mách nhà vua rằng các người là gái cả đấy.\n" +
            "\n" +
            "Công chúa cảm ơn bác ta rồi bảo các cô thiếu nữ:\n" +
            "\n" +
            "– Các em cố sức giẫm mạnh lên các hạt đỗ nhé.\n" +
            "\n" +
            "Sáng hôm sau nhà vua truyền mười hai người thợ săn đến phòng có rải hạt đỗ. Các cô thiếu nữ cố giẫm thật mạnh, bước đi của họ khỏe và chắc đến nỗi không một hạt đỗ nào lăn hoặc chuyển động, sau khi họ đi khỏi, nhà vua bảo sư tử:\n" +
            "\n" +
            "– Mày đánh lừa tao rồi, chúng đi chắc bước, đó là đàn ông.\n" +
            "\n" +
            "Sư tử đáp:\n" +
            "\n" +
            "– Vì biết là bị thử thách nên họ đã gắng đi cho chắc bước. Bệ hạ cứ để mười hai chiếc guồng kéo kéo sợi vào phòng, họ sẽ mừng rỡ và xán lại ngay, đàn ông thì không bao giờ thế.\n" +
            "\n" +
            "Nhà vua cho là kế hay, bèn sai để guồng kéo sợi vào phòng. Nhưng người hầu vốn thật thà với những người thợ săn, đến nói lộ cho họ biết hết mưu kế. Công chúa bảo riêng mười một thiếu\n" +
            "nữ: “Các em cố nhịn đừng có ngó tới guồng kéo sợi nhé”.\n" +
            "\n" +
            "Sáng hôm sau vua cho triệu mười hai người thợ săn đến, họ vào phòng không chú ý gì đến guồng sợi. Vua lại bảo sư tử:\n" +
            "\n" +
            "– Mày đánh lừa tao. Đúng là đàn ông rồi, vì chúng không nhìn gì đến guồng kéo sợi.\n" +
            "\n" +
            "Sư tử đáp:\n" +
            "\n" +
            "– Họ biết là bị thử thách nên cố nhịn đấy.\n" +
            "\n" +
            "Nhưng vua nhất định không tin sư tử nữa. Ngày nào mười hai người thợ săn cũng theo vua đi săn, càng ngày vua càng yêu quí họ. Một hôm trong khi họ đi săn, thì được tin vợ chưa cưới của nhà vua sắp tới. Người vợ chưa cưới chính thức nghe vậy đau khổ quá. Tim bị nhói lên ngã lăn xuống đất bất tỉnh nhân sự. Vua tưởng là người thợ săn yêu quí của mình bị làm sao vội chạy lại cứu. Vua lại tháo bao tay ấy thì thấy chiếc nhẫn mình đã tặng cho người vợ chưa cưới thứ nhất. Vua nhìn mặt nhận ra nàng. Lòng vua hồi hộp, vua hôn nàng lúc nàng mở mắt, vua bảo:\n" +
            "\n" +
            "– Em là của anh, anh là của em. Thiên hạ không ai thay đổi được điều ấy.\n" +
            "\n" +
            "Vua phái sứ giả đến gặp người vợ chưa cưới kia xin nàng quay về nước vì vua đã có vợ rồi. Ai đã tìm thấy chiếc chìa khóa cũ thì không cần đến chiếc mới nữa. Sau đó hôn lễ được cử hành. Sư tử được tha tội, vì quả là nó nói đúng sự thật.','https://truyencotich.vn/wp-content/uploads/2012/10/Peter-Pan-Wallpaper-classic-disney-7089871-1024-768-660x440.jpg',1)";
    private String SQLQuery003 = "INSERT INTO truyen VALUES (null,'Sự tích mặt trăng','Đất nước này có từ hồi mới khai thiên lập địa, ở đây ban đêm trời tối đen như mực, vì chẳng có trăng, sao chiếu sáng, bầu trời như một tấm thảm đen bao trùm khắp đất nước.\n" +
            "Một ngày kia có bốn chàng trai ở đất nước này rủ nhau đi chu du thiên hạ, họ tới một vương quốc khác, ở đây, sau khi mặt trời khuất núi thì thấy xuất hiện một quả cầu sáng dịu treo trên một cây sồi cổ đại. Ánh sáng tỏa chiếu khắp đất nước. Tuy không chói chang như ánh sáng mặt trời, nhưng dưới ánh sáng dịu ấy người ta cũng có thể nom rõ và phân biệt mọi vật.\n" +
            "Mấy khách bộ hành dừng chân đứng ngắm, họ hỏi một người nông dân đánh xe ngựa đi ngang, vật sáng đó là cái gì. Người kia đáp:\n" +
            "– Đó là mặt trăng. Ông trưởng thôn của chúng tôi mua ba Thalơ và đem treo ở đó. Hàng ngày ông ta phải đổ dầu và lau cho sạch để nó cháy đều và phát ra ánh sáng dịu. Ông ta nhận tiền công mỗi tuần một Thalơ.\n" +
            "Khi người nông dân đã đi khuất, một người trong bọn khách bộ hành nói:\n" +
            "– Loại đèn như thế này chắc chúng ta cũng cần, ở quê hương chúng ta cũng có một cây sồi cổ đại, chúng ta có thể treo nó lên cây. Vui sướng biết bao khi chúng ta không còn phải mò mẫm đi trong đêm.\n" +
            "Người thứ hai nói:\n" +
            "– Các anh có biết không, những người ở đây có thể đi mua cái khác về treo, chúng ta hãy mau mau lấy xe và ngựa chở ngay mặt trăng này đi.\n" +
            "Người thứ ba nói:\n" +
            "– Tôi trèo cây giỏi, để tôi trèo lên lấy nó xuống.\n" +
            "Người thứ tư dẫn xe và ngựa tới. Người thứ ba trèo lên cây, khoan một lỗ xuyên qua mặt trăng, lấy dây thừng xỏ buộc lại rồi thả nó xuống.\n" +
            "Khi quả cầu lóng lánh kia đã nằm gọn trên xe, họ lấy khăn phủ lên để cho không ai biết chuyện, họ lấy mặt trăng đem đi.\n" +
            "Họ đem được mặt trăng về nước mình một cách yên ổn và treo nó lên trên ngọn cây sồi cao. Ánh trăng chiếu sáng khắp cánh đồng, trong nhà ngoài ngõ tràn ngập ánh trăng, già trẻ lớn bé đều vui mừng. Những người tí hon đua nhau ra khỏi hang động để thưởng thức trăng, và trên thảo nguyên các thổ công xúng xính trong bộ quần áo đó cùng nhau dung dăng dung dẻ nhảy múa vòng tròn.\n" +
            "Bốn người hàng ngày lo đổ dầu, lau bồ hóng hàng tuần được lãnh tiền công.\n" +
            " Nhưng rồi cùng với năm tháng, họ trở nên già nua. Khi người thứ nhất ốm, biết mình không qua khỏi nên căn dặn mọi người mình muốn lấy một phần tư mặt trăng đem theo xuống chín suối. Sau khi người này chết, trưởng thôn trèo lên cây, lấy chiếc kéo tỉa cây cắt lấy một phần tư mặt trăng, đặt nó vào trong quan tài của người quá cố. Ánh trăng tuy không sáng như trước nhưng ít người nhận thấy điều đó. Khi người thứ hai qua đời, một phần tư khác cũng được cắt chia cho người đó. Ánh trăng không còn sáng tỏ nữa. Nhưng khi người thứ ba chết, một phần tư nữa lại bị cắt chôn theo cùng, giờ đây ánh trăng mờ ảo. Đến khi người thứ tư xuống mồ thì phần tư cuối cùng cũng được lấy xuống chôn cùng người quá cố. Giờ đây ban đêm lại tối đen như mực như khi trước kia. Mỗi khi đi đêm mọi người lại phải mang theo đèn nếu không thì lại cụng đầu vào nhau.\n" +
            "Ở dưới địa ngục lúc nào cũng tối tăm, bốn mảnh trăng kia được ghép lại thành một quả cầu sáng. Ánh trăng không chói chang như mặt trời, mà là ánh sáng dịu nên rất hợp với những cặp mắt của những người ở dưới địa ngục, họ động đậy, rồi thức tỉnh khỏi cơn ngủ triền miên. Họ vươn vai đứng dậy, trở nên vui tính và lại tiếp tục những nhịp điệu sống cũ của mình. Một số lại đi cờ bạc, nhảy múa, số khác lại đến các quán rượu vòi rượu uống, khi đã ngà ngà say thì bắt đầu cãi lộn làm huyên náo cả vùng, tiếp đến là rút gậy ăn mày ra đánh nhau. Tiếng huyên náo bởi cãi nhau và đánh lộn ngày càng to và vang xa, nó vang lên đến tận thiên đình.\n" +
            "Thánh Pétrus có nhiệm vụ canh giữ cổng trời nghe thấy huyên náo nghĩ rằng dưới địa ngục có nổi loạn. Thánh thổi tù và báo động tập hợp quân lính phòng khi quân ô hợp dưới địa ngục kéo lên thì đánh đuổi chúng xuống. Đợi mãi nhưng không thấy chúng kéo lên. Thánh Pétrus lên ngựa và phóng qua cửa trời xuống dưới địa ngục. Thánh dẹp yên và ra lệnh ai về mộ người ấy. Dẹp xong, thánh lấy mặt trăng đem theo về trời. Vì vậy mặt trăng treo trên trời như ngày nay chúng ta thấy.','https://truyencotich.vn/wp-content/uploads/2015/01/anh-dep-hoat-hinh-vui-nhon-mat-trang-660x440.jpg',1)";
    private String SQLQuery004 = "INSERT INTO truyen VALUES (null,'Con ngỗng vàng','Xưa có một người có ba con. Con thứ ba tên là chàng Ngốc thường bị khinh rẻ chế giễu và làm việc gì cũng bị gạt ra. Một hôm, con cả muốn vào rừng đốn củi. Trước khi anh ta đi, người mẹ cho anh ta một chiếc bánh trứng ngon lành và một chai rượu vang để mang theo ăn uống. Anh vào rừng gặp một ông lão nhỏ bé, tóc hoa râm, chào anh và nói:\n" +
            "\n" +
            "– Cho lão xin miếng bánh ở trong bị anh và một ngụm rượu vang. Lão vừa đói vừa khát đây. \n" +
            "\n" +
            "Anh chàng khôn ngoan đáp:\n" +
            "\n" +
            "– Nếu tôi cho lão bánh và rượu thì tôi chẳng còn gì! Thôi lão xéo đi!\n" +
            "\n" +
            "Rồi anh để kệ ông lão ở đấy mà đi. Anh đẵn cây được một lát thì trượt tay, rìu chém vào cánh tay, phải về nhà băng bó. Tai nạn ấy chính do ông lão bé nhỏ gây ra. Sau đó, người con thứ hai đi rừng. Người mẹ cũng cho một chiếc bánh trứng và một chai rượu vang y như với con cả. Ông lão bé nhỏ cũng đến xin anh miếng bánh và ngụm rượu. Người con thứ hai cũng rất khôn:\n" +
            "\n" +
            "– Tôi cho lão cái gì là tôi thiệt cái ấy. Thôi lão xéo đi!\n" +
            "\n" +
            "Rồi anh để kệ ông lão ở đấy mà đi. Anh cũng bị trừng phạt ngay: anh mới chặt cây được vài nhát thì chặt ngay vào chân, phải lê về nhà.\n" +
            "\n" +
            "Chàng Ngốc liền nói:\n" +
            "\n" +
            "– Thưa bố, bố để cho con đi đốn củi một lần.\n" +
            "\n" +
            "Bố đáp:\n" +
            "\n" +
            "– Thôi! Hai anh mày bị thương. Mày đốn củi thế nào được!\n" +
            "\n" +
            "Chàng Ngốc xin mãi, cuối cùng bố đành bảo:\n" +
            "\n" +
            "– Thôi thì mày cứ đi đi. Có vấp thì mới sáng mắt ra.\n" +
            "\n" +
            "Mẹ cho một chiếc bánh luộc ủ tro và một chai bia chua. Anh vào rừng thì cũng gặp một ông lão bé nhỏ tóc hoa râm, chào anh rồi bảo:\n" +
            "\n" +
            "– Cho lão xin một miếng bánh và một ngụm rượu, lão vừa đói vừa khát đây.\n" +
            "\n" +
            "Chàng Ngốc đáp:\n" +
            "\n" +
            "– Cháu chỉ có bánh ủ tro và bia chua thôi. Nếu cụ thấy tạm được, thì ông cháu ta ngồi xuống cùng đánh chén.\n" +
            "\n" +
            "Họ ngồi xuống. Chàng Ngốc rút bánh ủ tro ra thì thấy đó là một chiếc bánh trứng ngon lành; bia chua đã biến thành rượu vang ngon. Ăn uống xong, ông lão bảo:\n" +
            "\n" +
            "– Cháu tốt bụng, sẵn sàng chia của mình cho người khác. Để lão ban phúc cho. Chỗ kia có cây cổ thụ, cháu đẵn xuống sẽ thấy trong đám rễ cây có của quí.\n" +
            "\n" +
            "Nói xong ông lão từ biệt lên đường.\n" +
            "\n" +
            "Chàng Ngốc đi đẵn cây. Hạ cây xuống thì thấy trong đám rễ có một con ngỗng lông bằng vàng thật. Anh nhấc ngỗng lên ẵm vào một quán trọ để ngủ đêm. Chủ quán có ba con gái. Ba cô thấy ngỗng, tò mò không biết là chim gì mà lạ thế, chỉ muốn lấy một chiếc lông của nó. Cô cả nghĩ cách nhổ trộm một chiếc. Khi chàng Ngốc vừa ra, chị nắm ngay lấy cánh ngỗng. Nhưng tay bị dính chặt vào đó, không rút ra được. Một lát sau, cô thứ hai đến cũng chỉ chăm chăm muốn lấy một chiếc lông vàng. Cô vừa đụng đến cô chị thì bị dính ngay vào chị. Cô thứ ba cũng tới cũng định tâm lấy lông. Hai cô chị kêu lên:\n" +
            "\n" +
            "– Ối trời ơi là trời, tránh ra, tránh ra!\n" +
            "\n" +
            "Cô út chẳng hiểu tại sao lại phải tránh ra, nghĩ bụng các chị làm thì mình cũng làm được, liền nhảy lại. Cô vừa đụng tới các chị thì cũng bị dính vào. Cả ba cô suốt đêm phải ở liền với ngỗng. Sáng hôm sau, chàng ngốc mang ngỗng ra đi, cũng chẳng để ý đến ba cô dính vào ngỗng. Các cô đành lẽo đẽo theo sau, rẽ sang phải sang trái tùy theo bước của anh. Giữa đồng, cha xứ gặp cả đoàn người bèn nói:\n" +
            "\n" +
            "– Đồ gái quạ mổ, không biết xấu hổ à? Cứ bám lấy giai ra đồng như vậy coi có được không?\n" +
            "\n" +
            "Cha liền nắm tay cô út kéo lại; cha vừa đụng đến thì chính cha cũng bị dính vào và cũng phải lẽo đẽo đi theo. Một lúc sau, người giữ đồ thánh thấy cha xứ lẽo đẽo theo ba cô, ngạc nhiên quá hỏi:\n" +
            "\n" +
            "– Thưa cha, cha đi đâu mà vội vàng thế? Cha nhớ là hôm nay còn phải làm lễ rửa tội cho một đứa trẻ nữa cơ đấy.\n" +
            "\n" +
            "Ông ta chạy theo nắm áo cha thì cũng bị dính vào. Năm người đang bước thấp bước cao như vậy thì gặp hai bác nông dân vác cuốc ở đồng về. Cha xứ gọi họ, nhờ gỡ hộ mình và người giữ đồ thánh ra. Hai bác vừa sờ đến thì bị dính vào nốt. Như vậy là bảy người đi theo chàng Ngốc ôm ngỗng.\n" +
            "\n" +
            "Anh đi tới kinh kỳ. Nhà vua có một cô gái nghiêm nghị, không ai làm cô cười được. Vua phán là ai làm cho cô cười thì được lấy cô. Chàng Ngốc nghe thấy nói vậy, liền vác ngỗng và cả bảy người theo đuôi đến trước công chúa. Nàng thấy bảy người lếch thếch theo nhau, liền cười sằng sặc, không kìm lại được nữa. Chàng Ngốc liền đòi lấy nàng. Vua không thích chàng rể này, viện cớ nọ cớ kia để từ chối, ra điều kiện cho anh phải tìm ra người uống hết được một hầm rượu vang thì mới cho lấy. Chàng Ngốc nghĩ đến ông lão nhỏ bé, có thể giúp được mình,\n" +
            "liền vào rừng tìm. Tới chỗ cây bị đẵn, anh thấy có một người ngồi, mặt buồn rười rượi. Anh hỏi y sao lại buồn bao thế. Y đáp:\n" +
            "\n" +
            "– Tôi khát quá, uống bao nhiêu cũng không đỡ khát. Tôi không chịu được nước lã. Quả là tôi đã uống cạn một thùng rượu, nhưng chẳng qua mới như muối bỏ bể.\n" +
            "\n" +
            "Chàng Ngốc nói:\n" +
            "\n" +
            "– Thế để tôi giúp anh. Anh chỉ việc đi với tôi là tha hồ uống.\n" +
            "\n" +
            "Anh dẫn người ấy đến hầm rượu nhà vua. Y nhảy xổ vào những thùng rượu to, uống mãi, uống mãi đến căng cả bụng. Chưa hết một ngày, anh đã uống sạch cả hầm rượu.\n" +
            "\n" +
            "Chàng Ngốc lại đòi lấy công chúa. Nhưng vua bực lắm, không muốn để một tên vớ vẩn mà mọi người gọi là Ngốc lấy con gái mình. Vua lại ra những điều kiện mới: anh ta phải tìm cho ra được một người ăn nổi một núi bánh. Chàng Ngốc chẳng suy nghĩ gì lâu la, lại đi ngay vào rừng. Vẫn ở chỗ cũ có một người mặt mũi thiểu não, thắt chặt bụng bằng dây da và nói:\n" +
            "\n" +
            "– Tôi đã ăn cả một lò bánh, nhưng không ăn thua gì. Tôi háu đói quá. Bụng vẫn lép kẹp, phải thắt lại kẻo chết đói mất.\n" +
            "\n" +
            "Chàng Ngốc thấy vậy cả mừng bảo:\n" +
            "\n" +
            "– Thôi đi đi, đi với tôi thì tha hồ no nê.\n" +
            "\n" +
            "Anh dẫn người ấy vào triều. Vua cho tập trung bột mì cả nước lại rồi sai nướng một núi bánh khổng lồ. Người ở rừng chỉ ăn một ngày hết sạch cả núi bánh.\n" +
            "\n" +
            "Lần thứ ba, chàng Ngốc lại đòi lấy công chúa. Vua tìm cách thoái thác, đòi có một chiếc tàu đi được cả ở trên cạn lẫn dưới nước. Vua nói:\n" +
            "\n" +
            "– Nếu tàu ấy cặp bến thì lập tức ngươi được lấy con gái ta.\n" +
            "\n" +
            "Chàng Ngốc đi thẳng vào rừng. Ông lão được anh cho bánh vẫn ngồi đó, bảo anh:\n" +
            "\n" +
            "– Chính lão đã uống và ăn hộ cho anh. Để lão cho anh chiếc tàu. Gì lão cũng làm, vì anh đã cư xử với lão tử tế.\n" +
            "\n" +
            "Lão bèn cho anh một chiếc tàu đi được cả trên cạn lẫn dưới nước. Vua thấy không còn cách gì giữ con gái được nữa đành cho tổ chức đám cưới. Sau khi vua mất, chàng Ngốc lên ngôi. Vợ chồng sống hưởng hạnh phúc.','https://truyencotich.vn/wp-content/uploads/2012/10/18.jpg',1)";
    private String SQLQuery005 = "INSERT INTO truyen VALUES (null,'Thông Linh Phi','Sư phụ nói vận mệnh không phải do trời định, vận mệnh là do tự mình nỗ lực mà thay đổi. \n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://1.bp.blogspot.com/-mtWAbcdmhK4/XnzJZIvIUKI/AAAAAAACUnk/HokdEB8D3DsZwqSdnRoVD9WUDwuHn-DawCLcBGAsYHQ/s0/3.jpg',1)";
    private String SQLQuery006 = "INSERT INTO truyen VALUES (null,'Playful Kiss','Là một bộ phim hài tình cảm kể về cuộc sống của cô nàng Ha Ni (do Jung So Min thủ vai) cùng tình cảm dành cho cậu bạn Seung Jo \n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://avatar-ex-swe.nixcdn.com/playlist/2013/12/04/a/c/b/4/1386155685366_500.jpg',1)";
    private String SQLQuery007 = "INSERT INTO truyen VALUES (null,'Liar Game','Bộ phim nổi tiếng Liar Game được chuyển thể từ bộ truyện tranh Nhật Bản cùng tên là “Liar game” của tác giả Shinobu Kaitani. Bộ phim là câu chuyện khá hay và hấp dẫn, đúng hơn là một bài học sâu sắc về đồng tiền của Nam Da Jung (do Kim So Eun đóng) \n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://bookbuy.vn/Res/Images/Product/liar-game-tap-5_91300_1.PNG',1)";
    private String SQLQuery008 = "INSERT INTO truyen VALUES (null,'Orange Marmalade','Khi Jung Jae Min (do Yeo Jin Goo đóng) phát hiện tình cảm của mình dành cho Baek Ma Ri (do Seolhyun đóng) nhưng trớ trêu anh không hề nhận ra cô chính là một ma cà rồng ẩn thân. Hai nhân vật chính hiện thân cho hai số phận\n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://i.pinimg.com/originals/f6/7a/91/f67a91f38727620626d0e0558c8099a9.jpg',1)";
    private String SQLQuery009 = "INSERT INTO truyen VALUES (null,'Dr. Jin',' Đây là bộ phim được chuyển thể từ bộ manga “Jin” của tác giả Motoka Murakami\n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://media.ngoisao.vn/news/2012/6/28/67/18685timeslipdrjinjpg1340856436.jpg',1)";
    private String SQLQuery0010 = "INSERT INTO truyen VALUES (null,'Yebbeun Namja',' Có thể nói là một phim tình cảm siêu hài cộng với siêu \"lố\" của nhân vật Dokgo Ma Te (do Jang Geun Suk đóng) \n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTUt3UiVsabRVtoQUvwSWipw28TQ72jVXmfBQ94LUEoZx3aqpCR76psFzlexBmiVAP8oxs&usqp=CAU',1)";
    private String SQLQuery0011 = "INSERT INTO truyen VALUES (null,' Ai Cho Anh Lên Giường','Tác giả: An Tĩnh Nguồn: sstruyen, truyenfull Cô không ngờ khi yêu anh lại là một người đàn ông hay ghen như vậy,\n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://img.thichtruyen.vn/data/anh-truyen/2015/ai-cho-anh-len-giuong-thichtruyen.vn.jpg',1)";
    private String SQLQuery0012 = "INSERT INTO truyen VALUES (null,' Cô bé quàng khăn đỏ',' Truyện kể về một cô bé, gọi là cô bé quàng khăn đỏ, đi vào rừng để đến nhà bà đưa thức ăn cho người bà đang bị bệnh.\n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://product.hstatic.net/1000219449/product/bia_mut_-_aladdin_va_cay_den_than-01_-_bia_1_c3eca77371074ba19524af5bc150867d_master.jpg',1)";
    private String SQLQuery0014 = "INSERT INTO truyen VALUES (null,'Aladdin và cây đèn thần',' Câu chuyện xoay quanh nhân vật chính là chàng trai có tên là Aladdin, sống cùng với người mẹ góa tên là Mustapha tại kinh đô của một đất nước nọ.\n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://product.hstatic.net/1000219449/product/bia_mut_-_aladdin_va_cay_den_than-01_-_bia_1_c3eca77371074ba19524af5bc150867d_master.jpg',1)";
    private String SQLQuery0015 = "INSERT INTO truyen VALUES (null,'Alibaba và bốn mươi tên cướp','Câu chuyện kể về Alibaba là một chàng tiều phu nghèo nhưng hiền lành, không tham lam còn người anh trai của chàng tên là Cassim \n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://salt.tikicdn.com/media/catalog/product%2Fi%2Fm%2Fimg821.u2487.d20160823.t150037.881099.jpg',1)";

    private String SQLQuery0016 = "INSERT INTO truyen VALUES (null,'Nàng công chúa ngủ công rừng',' Chuyện kể về một nàng công chúa xinh đẹp có tên là là Aurora\n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://product.hstatic.net/1000186499/product/nang_cong_chua_ngu_trong_rung_3-2020_58a4e30c0755415f8390b778c86529cf_master.jpg',1)";
    private String SQLQuery0017 = "INSERT INTO truyen VALUES (null,'Ông lão đánh cá và con cá vàng','Ông lão đánh cá và con cá vàng kể về câu chuyện một ông lão nghèo làm nghề đánh cá ngoài biển. \n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://upload.wikimedia.org/wikipedia/vi/archive/c/c4/20210322005210%21%C3%94ng_l%C3%A3o_%C4%91%C3%A1nh_c%C3%A1_v%C3%A0_con_c%C3%A1_v%C3%A0ng.jpg',1)";

    private String SQLQuery0019 = "INSERT INTO truyen VALUES (null,'Tình yêu của nàng rắn Naja',' (Câu chuyện nhỏ về 1 thanh niên thích bán nhân rắn và gặp gỡ người anh ta thích ở tiệm bói toán)\n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://cdn.statically.io/img/truyenvn.tv/f=auto/tin/wp-content/uploads/2020/06/doc-truyen-tranh-18-co-dau-cua-ong-vua-dau-mo.jpg',1)";
    private String SQLQuery0020 = "INSERT INTO truyen VALUES (null,'Muchimuchi Oyako to Hame Houdai!','1 cô gái vếu bự tỏ tình với cậu bạn cùng lớp có chân diện giống y chang như thằng cha đã ly thân của mẹ cô ấy.\n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://komeloli.net/uploads/covers/muchi-muchi-angel-vol-12-352.jpg',1)";
    private String SQLQuery0021 = "INSERT INTO truyen VALUES (null,'Golgo 13','Đây là một trong những bộ truyện tranh lớn tuổi nhất vẫn còn được xuất bản cho đến hiện tại. Golgo 13 được coi\n" +

            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://s199.imacdn.com/ta/2020/05/10/f721fb10f1ceb9f7_ca7829506e1104cf_5405115890989206129205.jpg',1)";
    private String SQLQuery0022 = "INSERT INTO truyen VALUES (null,'Oishinbo','Đây là một bộ truyện mang chủ đề ẩm thực, hài hước. Bộ truyện phiêu lưu mô tả của nhà báo ẩm thực Shiro Yamaoka\n" +
            "là James Bond của Nhật Bản\n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://cdn.myanimelist.net/images/anime/1681/109663.jpg',1)";
    private String SQLQuery0023 = "INSERT INTO truyen VALUES (null,'Con Rể','Bộ truyện tranh Con Rể kể về mối quan hệ tình cảm giữa Yoo Aeran và Kim Jihoon dù trước mặt mọi người, hai người là mẹ vợ - con rể\n" +
            "là James Bond của Nhật Bản\n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://truyenvn.tv/wp-content/uploads/2020/09/truyen-con-re-scaled-e1599270972866.jpg',1)";
    private String SQLQuery0024 = "INSERT INTO truyen VALUES (null,'Golgo ','Cảnh báo độ tuổi: Bộ truyện bạn đang xem thuộc nhóm Truyện Tranh 18+, bao gồm nhiều hình ảnh không phù hợp với trẻ em dưới 18 tuổi. Nếu bạn dưới 18 tuổi, vui lòng chọn một bộ truyện tranh phù hợp khác để giải trí.\n" +

            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://truyenvn.tv/wp-content/uploads/2021/10/truyen-phat-thanh-vien.jpg',1)";
    private String SQLQuery0025 = "INSERT INTO truyen VALUES (null,'Midarana Kakyou Ni Su Kuu Mono','Tooru và chị gái Yume cuối cùng phải vào bệnh viện sau một tai nạn giao thông khiến cha của họ chết não. Đột nhiên Itou Yuuzen xuất hiện và đưa họ đi dưới sự bảo vệ của giáo phái tôn giáo ông\n" +
            "là James Bond của Nhật Bản\n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://truyenvn.tv/wp-content/uploads/2019/11/midarana-kakyou-ni-su-kuu-mono_1574083536.jpg',1)";
    private String SQLQuery0026 = "INSERT INTO truyen VALUES (null,'Game Obu Familia – Family Senki','Cùng gia đình bị triệu hồi sang thế giới khác, làm gì thì vào đọc là biết ...............\n" +
            "là James Bond của Nhật Bản\n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://truyenvn.tv/wp-content/uploads/2019/10/game-obu-familia-family-senki_1532526327.jpg',1)";
    private String SQLQuery0027 = "INSERT INTO truyen VALUES (null,'Võ Thần Chúa Tể','Thiên Vũ đại lục nhất đại truyền kỳ Tần Trần, bởi vì bạn tốt phản bội bất ngờ ngã xuống Võ vực\n" +
            "là James Bond của Nhật Bản\n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://truyenvn.tv/wp-content/uploads/2019/10/vo-than-chua-te_1493643231.jpg',1)";
    private String SQLQuery0028 = "INSERT INTO truyen VALUES (null,'Deatte 5 Byou De Battle','Một ngày nọ, cậu học sinh cao trung mê game, cuồng kẹo Shiroyanagi Akira bị kéo vào một trận chiến bởi một cô gái bí ẩn tự xưng là Mion. \n" +
            "là James Bond của Nhật Bản\n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://truyenvn.tv/wp-content/uploads/2021/09/truyen-deatte-5-byou-de-battle-1.jpg',1)";


    public databasedoctruyen(@Nullable Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }

    private String SQLQuery10 = "INSERT INTO truyen VALUES (null,'Hasaki','Ngày xửa ngày xưa, xưa lắm rồi khi mà muôn thú, cây cỏ, con người còn trò chuyện được với nhau. Trên đồng cỏ rậm ven khu làng có một loài cây gọi là cây đa. Đó là một thứ cây to, khỏe, lá của nó rậm rạp đến nỗi không một tia nắng nào có thể lọt qua được. Vào những ngày trời nắng nóng người ta thường nghỉ chân một lát và trò chuyện hàn huyên cùng cây dưới bóng cây mát rượi. Mọi người ai cũng biết rằng cây đa rất thông thái vì cây đã có tuổi, đã từng trải.\n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://i.pinimg.com/564x/97/37/5f/97375f5139de0712a8f0230f71c5049b.jpg',1)";
    private String SQLQuery00 = "INSERT INTO truyen VALUES (null,'Nohito','Ngày xửa ngày xưa, xưa lắm rồi khi mà muôn thú, cây cỏ, con người còn trò chuyện được với nhau. Trên đồng cỏ rậm ven khu làng có một loài cây gọi là cây đa. Đó là một thứ cây to, khỏe, lá của nó rậm rạp đến nỗi không một tia nắng nào có thể lọt qua được. Vào những ngày trời nắng nóng người ta thường nghỉ chân một lát và trò chuyện hàn huyên cùng cây dưới bóng cây mát rượi. Mọi người ai cũng biết rằng cây đa rất thông thái vì cây đã có tuổi, đã từng trải.\n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://vnkings.com/wp-content/uploads/2018/09/BBB142C2-176C-4461-ACAE-09720927F641.jpeg',1)";
    private String SQLQuery01 = "INSERT INTO truyen VALUES (null,'Manga','Ngày xửa ngày xưa, xưa lắm rồi khi mà muôn thú, cây cỏ, con người còn trò chuyện được với nhau. Trên đồng cỏ rậm ven khu làng có một loài cây gọi là cây đa. Đó là một thứ cây to, khỏe, lá của nó rậm rạp đến nỗi không một tia nắng nào có thể lọt qua được. Vào những ngày trời nắng nóng người ta thường nghỉ chân một lát và trò chuyện hàn huyên cùng cây dưới bóng cây mát rượi. Mọi người ai cũng biết rằng cây đa rất thông thái vì cây đã có tuổi, đã từng trải.\n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://upload.wikimedia.org/wikipedia/vi/7/72/PdVDVSL0002.jpg',1)";
    private String SQLQuery02 = "INSERT INTO truyen VALUES (null,'Supper hero','Ngày xửa ngày xưa, xưa lắm rồi khi mà muôn thú, cây cỏ, con người còn trò chuyện được với nhau. Trên đồng cỏ rậm ven khu làng có một loài cây gọi là cây đa. Đó là một thứ cây to, khỏe, lá của nó rậm rạp đến nỗi không một tia nắng nào có thể lọt qua được. Vào những ngày trời nắng nóng người ta thường nghỉ chân một lát và trò chuyện hàn huyên cùng cây dưới bóng cây mát rượi. Mọi người ai cũng biết rằng cây đa rất thông thái vì cây đã có tuổi, đã từng trải.\n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://metruyenchu.net/uploads/Images/nhung-nam-o-marvel-lam-super-hero.jpg',1)";
    private String SQLQuery03 = "INSERT INTO truyen VALUES (null,'Tomiya','Ngày xửa ngày xưa, xưa lắm rồi khi mà muôn thú, cây cỏ, con người còn trò chuyện được với nhau. Trên đồng cỏ rậm ven khu làng có một loài cây gọi là cây đa. Đó là một thứ cây to, khỏe, lá của nó rậm rạp đến nỗi không một tia nắng nào có thể lọt qua được. Vào những ngày trời nắng nóng người ta thường nghỉ chân một lát và trò chuyện hàn huyên cùng cây dưới bóng cây mát rượi. Mọi người ai cũng biết rằng cây đa rất thông thái vì cây đã có tuổi, đã từng trải.\n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được','https://i.pinimg.com/736x/33/5d/8f/335d8fa2f1afdaf0748d01d3dbc7c4a8.jpg',1)";
    private String SQLQuery04 = "INSERT INTO truyen VALUES (null,'Cây Khế','Truyện Cổ Tích Việt Nam - Cây Khế.\n" +
            "\n" +
            "\n" +
            "Một hôm, có một cậu bé chăn cừu ngồi nghỉ mát dưới gốc cây sau một ngày dài phơi mình dưới nắng cậu bé thấy người mệt mỏi và nóng bức. Một làn gió mơn man thổi thoa nhẹ lên tấm thân mỏi mệt của chú bé. Cậu bé bắt đầu thấy buồn ngủ. Vừa đặt mình xuống cậu bé bỗng ngước mắt nhìn lên những cành cây. Bấy giờ cậu bé bỗng thấy mình thật kiêu hãnh, cậu vẫn thường hay khoe với mọi người rằng cậu có tài chăn cừu và đàn cừu của cậu nhờ vậy mà lớn rất nhanh. Khi cậu bé phát hiện ra cây đa chỉ có những chùm quả rất nhỏ, nó bắt đầu thấy ngạc nhiên. Cậu bắt đầu chế giễu: hư, một cái cây to khỏe thế này mà làm sao chỉ có những bông hoa những chùm quả bé tí tẹo thế kia, mọi người vẫn bảo là cái cây này thông thái lắm kia mà nhưng làm sao nó có thể thông thái khi mà quả của nó chỉ toàn bé xíu như vậy. Dĩ nhiên là cây đa nghe hết những lời của cậu bé nhưng cây vẫn im lặng và cành lá chỉ khẽ rung rinh đủ để cho gió cất lên khúc hát ru êm dịu. Cậu bé bắt đầu ngủ, cậu ngáy o o…. Cốc.\n" +
            "Quả đa nhỏ rụng chính giữa trán của cậu bé, nó bừng tỉnh nhưng càu nhàu: “Gừm… người ta vừa mới chợp mắt được có một tí”, rồi nó nhặt quả đa lên chưa hết chưa biết định làm gì với quả đa này bỗng nhiên cậu bé nghe thấy có tiếng cười khúc khích, cậu nghe thấy cây hỏi:\n" +
            "– Có đau không ?.\n" +
            "– Không nhưng mà làm người ta mất cả giấc ngủ .\n" +
            "– Đó là bài học cho cậu bé to đầu đấy. Cậu chẳng vừa nhạo tôi là chỉ sinh ra toàn những quả nhỏ xíu là gì.\n" +
            "– Tôi nhạo đấy tại sao người đời lại bảo bác là thông thái được nhỉ? Phá giấc ngủ trưa của người khác! Thế cũng là thông minh chắc!.\n" +
            "Cây cười và nói: này này anh bạn anh hãy nghe đây những chiếc lá của tôi cho cậu bóng mát để cậu lấy chỗ nghỉ ngơi. Ừ thì cứ cho là quả của tôi nó bé đi chăng nữa nhưng chẳng lẽ cậu không thấy rằng tạo hóa hoạt động rất hoàn chỉnh đó sao. Cậu thử tưởng tượng xem, nếu quả của tôi to như quả dừa thì điều gì sẽ xảy ra khi nó rơi vào đầu cậu.\n" +
            "Cậu bé im thin thít: ừ nhở. Cậu chưa hề nghĩ đến điều này bao giờ cả.\n" +
            "Cây lại nhẹ nhàng tiếp lời:\n" +
            "– Những người khiêm tốn có thể học hỏi rất nhiều điều từ việc quan sát những vật xung quanh đấy cậu bé ạ.\n" +
            "– Vâng bác đa bác cứ nói tiếp đi.\n" +
            "– Cậu hãy bắt đầu làm bạn với những gì ở quanh cậu. Chúng ta tất cả đều cần tới nhau. Cậu cứ nhìn bầy ong kia mà xem. Nhờ có ong mà hoa của tôi mới có thể trở thành quả. Thế còn bầy chim kia thì sao. Chúng làm tổ ngay giữa tán lá của tôi đây này. Những con chim bố mẹ kia phải làm việc vất vả cả ngày để bắt sâu nuôi con và cậu có biết việc làm đó có ý nghĩa gì với tôi không?.\n" +
            "– Không, có ý nghĩa gì vậy hả bác?.\n" +
            "– Sâu ăn lá chính vậy loài chim kia chính là những người bạn của tôi. Chúng còn giúp cả cậu nữa đấy, sở dĩ cừu của cậu có đủ lá và cỏ để ăn là vì chim chóc đã tiêu diệt hết các loài côn trùng và sâu bọ. Và chưa hết đâu cậu bé ạ!.\n" +
            "– Còn gì thế nữa hả bác đa.\n" +
            "– Cậu hãy nhìn xuống chân mình mà xem, những chiếc lá rụng tạo thành lớp thảm mục, những con sâu đào đất ngoi lên để ăn lá, chúng đào đất thành những lỗ nhỏ, nhờ đó không khí có thể vào được trong đất. Có không khí trong đất nên bộ rễ của tôi mới khỏe thế nào đấy. Rễ khỏe nên tôi cũng khỏe hơn. Nào thế bây giờ cậu trẻ đã hiểu chưa?.\n" +
            "– Cháu hiểu rồi thưa bác. Bác tha lỗi cho cháu nhé vì đã cười nhạo bác bác đa ạ.\n" +
            "– Không sao bây giờ cháu hãy ra dắt cừu về đi.\n" +
            "\n" +
            "\n" +
            "Ý nghĩa câu chuyện: Có thể cậu bé chăn cừu không phải ngay sau đó sẽ trở nên khiêm tốn, học hỏi luôn được nhưng rõ ràng là cậu đã nhận ra người ta không thể sống lẻ loi được.','https://img.websosanh.vn/v2/users/root_product/images/kho-tang-truyen-co-tich-viet/acKSjqf6yTaF.jpg?compress=85',1)";
    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQLQuery);
        db.execSQL(SQLQuery1);
        db.execSQL(SQLQuery2);
        db.execSQL(SQLQuery3);
        db.execSQL(SQLQuery4);
        db.execSQL(SQLQuery5);
        db.execSQL(SQLQuery6);
        db.execSQL(SQLQuery7);
        db.execSQL(SQLQuery8);
        db.execSQL(SQLQuery88);
        db.execSQL(SQLQuery888);
        db.execSQL(SQLQuery8888);
        db.execSQL(SQLQuery88888);
        db.execSQL(SQLQuery001);
        db.execSQL(SQLQuery002);
        db.execSQL(SQLQuery003);
        db.execSQL(SQLQuery004);
        db.execSQL(SQLQuery005);
        db.execSQL(SQLQuery006);
        db.execSQL(SQLQuery007);
        db.execSQL(SQLQuery008);
        db.execSQL(SQLQuery009);
        db.execSQL(SQLQuery0010);
        db.execSQL(SQLQuery0011);
        db.execSQL(SQLQuery0012);
        db.execSQL(SQLQuery0014);
        db.execSQL(SQLQuery0015);
        db.execSQL(SQLQuery0016);
        db.execSQL(SQLQuery0017);
        db.execSQL(SQLQuery0019);
        db.execSQL(SQLQuery0020);
        db.execSQL(SQLQuery0021);
        db.execSQL(SQLQuery0022);
        db.execSQL(SQLQuery0023);
        db.execSQL(SQLQuery0024);
        db.execSQL(SQLQuery0025);
        db.execSQL(SQLQuery0026);
        db.execSQL(SQLQuery0027);
        db.execSQL(SQLQuery0028);
        db.execSQL(SQLQuery11);
        db.execSQL(SQLQuery12);
        db.execSQL(SQLQuery13);
        db.execSQL(SQLQuery10);
        db.execSQL(SQLQuery02);
        db.execSQL(SQLQuery00);
        db.execSQL(SQLQuery01);
        db.execSQL(SQLQuery03);
        db.execSQL(SQLQuery04);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void AddTaiKhoan(TaiKhoan taiKhoan){
        SQLiteDatabase db = this.getWritableDatabase();

        //không thể lưu trực tiếp xuống insert nên thông qua contentvalues
        ContentValues values = new ContentValues();
        values.put(TEN_TAI_KHOAN,taiKhoan.getmTenTaiKhoan());
        values.put(MAT_KHAU,taiKhoan.getmMatKhau());
        values.put(EMAIL,taiKhoan.getmEmail());
        values.put(PHAN_QUYEN,taiKhoan.getmPhanQuyen());

        db.insert(TABLE_TAIKHOAN,null,values);
        //đóng lại db cho an toàn
        db.close();
        //Log.e("Add Tai Khoan ","thành công");
    }


    //Lấy tất cả tài khoản
    public Cursor getData(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res =  db.rawQuery( "select * from "+TABLE_TAIKHOAN , null );
        return res;
    }



    //Thêm truyện
    public void AddTruyen(Truyen truyen){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(TEN_TRUYEN,truyen.getTenTruyen());
        values.put(NOI_DUNG,truyen.getNoiDung());
        values.put(IMAGE,truyen.getAnh());
        values.put(ID_TAI_KHOAN,truyen.getID_TK());

        db.insert(TABLE_TRUYEN,null,values);
        db.close();
        Log.e("Add Truyện : ","Thành công");
    }

    //Thêm đánh giá
    public void AddDanhGia(DanhGia danhgia){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(NOI_DUNG_DANH_GIA,danhgia.getNoiDungDanhGia());
        // values.put(ID_TAI_KHOAN,danhgia.getIDTK());
        values.put(TEN_TAI_KHOAN,danhgia.getTenTK());
        values.put(TEN_TRUYEN, danhgia.getTenTruyen());
        db.insert(TABLE_DANH_GIA,null,values);
        db.close();
        Log.e("Add đánh giá : ","Thành công");
    }



    //Lấy tin mới nhất
    public Cursor getData1(){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res =  db.rawQuery( "select * from "+TABLE_TRUYEN+" ORDER BY "+ID_TRUYEN+" ASC LIMIT 4" , null );
        return res;
    }

    public Cursor getData4(){

        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res =  db.rawQuery( "select * from "+TABLE_TRUYEN+" ORDER BY "+ID_TRUYEN+" ASC LIMIT 7" , null );
        return res;
    }




    //Lấy tất cả truyện
    public Cursor getData2(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_TRUYEN,null);
        return res;
    }

    //Lấy tất cả đánh giá
    public Cursor getData3(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM "+TABLE_DANH_GIA,null);
        return res;
    }


    //Xóa truyện với id = i
    public int Delete(int i){
        SQLiteDatabase db = this.getReadableDatabase();

        int res = db.delete("truyen",ID_TRUYEN+" = "+i,null);
        return res;

    }


}

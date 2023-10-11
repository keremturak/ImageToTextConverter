# ImageToTextConverter

### Tessdata Dosyasının Yolu

Eğer projenizi çalıştırmak için Tesseract OCR kullanıyorsanız, doğru `tessdata` dosyasını indirip projenize dahil etmelisiniz. İşte bu adımları izleyebilirsiniz:

1. [Tesseract OCR'nin resmi dokümantasyonuna gidin](https://tesseract-ocr.github.io/tessdoc/) ve sürümünüze uygun olanı indirin ve kurulumu yapın.

2. Yukarıdaki linkten, projenizin diline uygun `tessdata` dosyasını indirin. Örneğin, İngilizce için `eng.traineddata` dosyasını indirebilirsiniz.

3. Projenizin bir kısmında, `tessdata` adında bir klasör oluşturun.

4. İndirdiğiniz `eng.traineddata` dosyasını bu klasöre kopyalayın.

5. Projeyi başlatın ve image dosyalarını texte çevirin.

Eğer bir hata alırsanız, logları kontrol edin ve tessdata dosyasının doğru yolu olduğundan emin olun. Daha fazla bilgi için projenizin kılavuzuna başvurun.

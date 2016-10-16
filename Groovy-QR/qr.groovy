@Grapes(
    @Grab(group='com.google.zxing', module='core', version='3.2.1')
)

//source: http://mvnrepository.com/artifact/com.google.zxing/core/3.2.1

import java.awt.Color
import java.awt.Graphics2D
import java.awt.image.BufferedImage
import java.io.File
import java.io.IOException
import java.util.EnumMap
import java.util.Map
 
import javax.imageio.ImageIO
 
import com.google.zxing.BarcodeFormat
import com.google.zxing.EncodeHintType
import com.google.zxing.WriterException
import com.google.zxing.common.BitMatrix
import com.google.zxing.qrcode.QRCodeWriter
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel
 
 
public class generarQR {
 
	public static void main(String[] args) {

		String myCodeText = "http://facebook.com/"
		String misDatos="http//:www.twitter.com/karlosins"
		String filePath = "/Users/makingdevs/Documents/proyectos/groovy/qr/QR.png"
		int size = 250
		String fileType = "png"
		File myFile = new File(filePath)

		try {
			
			Map<EncodeHintType, Object> hintMap = new EnumMap<EncodeHintType, Object>(EncodeHintType.class)
			hintMap.put(EncodeHintType.CHARACTER_SET, "UTF-8")
			
			hintMap.put(EncodeHintType.MARGIN, 1) /* default = 4 */
			hintMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L)
 
			QRCodeWriter qrCodeWriter = new QRCodeWriter()
			BitMatrix byteMatrix = qrCodeWriter.encode(misDatos, BarcodeFormat.QR_CODE, size,
					size, hintMap)
			int CrunchifyWidth = byteMatrix.getWidth()
			BufferedImage image = new BufferedImage(CrunchifyWidth, CrunchifyWidth,
					BufferedImage.TYPE_INT_RGB)
			image.createGraphics()
 
			Graphics2D graphics = (Graphics2D) image.getGraphics()
			graphics.setColor(Color.WHITE)
			graphics.fillRect(0, 0, CrunchifyWidth, CrunchifyWidth)
			graphics.setColor(Color.BLACK)
 
			for (int i = 0; i < CrunchifyWidth; i++) {
				for (int j = 0; j < CrunchifyWidth; j++) {
					if (byteMatrix.get(i, j)) {
						graphics.fillRect(i, j, 1, 1)
					}
				}
			}

			ImageIO.write(image, fileType, myFile)
		} catch (WriterException e) {
			e.printStackTrace()
		} catch (IOException e) {
			e.printStackTrace()
		}


		println("\n\nQR Creado con éxito")
	}
}
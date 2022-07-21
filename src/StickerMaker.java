import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class StickerMaker {

  private static final double MULT_FACTOR = 0.2;

  public void cria(InputStream inputStream, String nomeArquivo) throws Exception {

    BufferedImage imagemOriginal = ImageIO.read(inputStream);

    // Cria nova imagem em memória com transparência e com tamanho novo
    int largura = imagemOriginal.getWidth();
    int altura = imagemOriginal.getHeight();
    int novaAltura = (int) (altura * MULT_FACTOR) + altura;
    BufferedImage novaImagem = new BufferedImage(largura, novaAltura, BufferedImage.TRANSLUCENT);

    // Copiar a imagem original para nova imagem (Em memória)
    Graphics2D graphics = (Graphics2D) novaImagem.getGraphics();
    graphics.drawImage(imagemOriginal, 0, 0, null);

    // Configurar texto
    int fonteLetra = (int) (altura * MULT_FACTOR / 2);
    var fonte = new Font("Comic Sans MS", Font.BOLD, fonteLetra);
    graphics.setColor(Color.YELLOW);
    graphics.setFont(fonte);

    // Escrever uma frase na nova imagem
    graphics.drawString("TOPZERA ", 125, novaAltura - 50);

    // Escrever a nova imagem em um arquivo
    ImageIO.write(novaImagem, "png", new File(nomeArquivo));
  }

}

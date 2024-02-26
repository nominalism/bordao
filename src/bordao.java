import javax.mail.*;
import javax.mail.internet.*;
import java.time.Duration;
import java.util.Properties;
import java.util.Timer;
import java.util.TimerTask;
import java.util.Random;

public class bordao {

    private static final String SMTP_HOST = "smtp.gmail.com";
    private static final int SMTP_PORT = 587;
    private static final String EMAIL_REMETENTE = "seu email (precisa ser gmail pelas configurações anteriores a essa)";
    private static final String SENHA_REMETENTE = "sua senha";
    private static final String EMAIL_DESTINATARIO = "email para o qual será enviado";
    private static final String ASSUNTO_EMAIL = "titulo";
    private static final String[] BORDOES = {
            "A persistência é o caminho do êxito.",
            "O sucesso é ir de fracasso em fracasso sem perder o entusiasmo.",
            "Só se pode alcançar um grande êxito quando nos mantemos fiéis a nós mesmos.",



            "Se você não tem medo, você não está indo rápido o suficiente.",
            "Eu não vim para explicar, vim para confundir!",
            "Prefiro ser essa que sou do que ser uma que não sou.",
            "Boa noite, Brasil!",
            "Tô te ligando!",
            "Que legal!",
            "A televisão é um monstro que come os seus próprios filhos.",
            "Sou uma mulher de sorte.",
            "A arquitetura é a arte de organizar o espaço.",
            "Tudo o que eu faço é pensar como se estivesse jogando futebol.",



            "Dinheiro não traz felicidade.",
            "Carminha, tu vai pagar!",
            "Feia eu sou, mas burra não!",
            "Eu sou Ruth! Eu sou Raquel!",
            "Tinha que ser o sheik!",
            "Guarde esse segredo nos porões da sua alma!",
            "A viúva Porcina é uma santa!",
            "Que Brasil você quer para o seu filho?",
            "A culpa é da malandragem!",



            "Dadinho tá suave!",
            "Jesus Cristo!",
            "Se Deus me ajudar, eu pago!",
            "A vida é um sopro!",
            "Caveirão não sobe morro!",



            "Que bando de loucos!",
            "É nóis!",
            "Didi, meu! Didi, meu!",
            "E aí, galera?",



            "O importante é que a gente se divirta.",
            "Quem não se comunica se trumbica.",
            "A vida é uma peça de teatro, e eu sou a vedete.",
            "Domingão do Faustão!",
            "Você é o número 1!",
            "Parabéns para você!",
            "O programa do Jô.",
            "De frente com Gabi.",
            "A forma segue a função.",
            "O futebol é a coisa mais importante entre as menos importantes.",



            "Anunciação",
            "Andança",
            "O Leãozinho",
            "Acontece",
            "Construção",
            "Aquele Abraço",
            "Taj Mahal",
            "Garota de Ipanema",
            "Infiel",
            "Ouro de Tolo",



            "E o vento levou... meus planos.",
            "Eu quando...",
            "Olha pra mim, Carol!",
            "Nyan nyan nyan nyan!",
            "Ai, que susto!",
            "Ai, meu Deus!",
            "É sucesso!",
            "I want you!",
            "Problem?",
            "Yao Ming face!",



            "Say my name!",
            "How you doin'?",
            "Yabba-Dabba-Doo!",
            "Hakuna Matata!",
            "To infinity and beyond!",
            "Live long and prosper!",
            "May the Force be with you.",
            "Hasta la vista, baby.",
            "I'll be back.",
            "Hasta la vista, baby.",



            "A vida é boa demais pra ser levada a sério.",
            "A gente aprende com os erros, mas quem manda na vida é a gente.",
            "A felicidade não está no destino, mas sim no caminho.",
            "A melhor maneira de prever o futuro é criá-lo.",
            "A única coisa constante na vida é a mudança.",
            "A vida é feita de momentos, então aproveite cada um deles.",
            "A felicidade é um estado de espírito, não um destino.",
            "A vida é curta demais para ser infeliz.",
            "A melhor maneira de se livrar de um problema é enfrentá-lo.",
            "A única maneira de fazer um bom trabalho é amar o que você faz.",

    };
    public static void main(String[] args) {

        Properties props = new Properties();
        props.put("mail.smtp.host", SMTP_HOST);
        props.put("mail.smtp.port", SMTP_PORT);
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_REMETENTE, SENHA_REMETENTE);
            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                try {

                    String bordao = getRandomBordao();

                    Message message = new MimeMessage(session);
                    message.setFrom(new InternetAddress(EMAIL_REMETENTE));
                    message.setRecipient(Message.RecipientType.TO, new InternetAddress(EMAIL_DESTINATARIO));
                    message.setSubject(ASSUNTO_EMAIL);
                    message.setText(bordao);

                    Transport.send(message);
                } catch (MessagingException e) {
                    e.printStackTrace();
                }
            }
        }, 0, Duration.ofSeconds(10).toMillis());
    }


    private static String getRandomBordao() {
        Random random = new Random();
        int index = random.nextInt(BORDOES.length);
        return BORDOES[index];
    }
}

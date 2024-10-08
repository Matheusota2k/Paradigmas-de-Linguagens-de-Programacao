package ListaDeExercicio.Java;

public class Config {
    private static Config instancia = null;
    private String tema;
    private String idioma;

    private Config() {
        inicializar();
    }

    public static Config getInstancia() {
        if (instancia == null) {
            instancia = new Config();
        }
        return instancia;
    }

    private void inicializar() {
        this.tema = "claro";
        this.idioma = "português";
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public String getConfiguracoes() {
        return "Tema: " + this.tema + ", Idioma: " + this.idioma;
    }

    public static void main(String[] args) {
        Config config1 = Config.getInstancia();
        config1.setTema("escuro");

        Config config2 = Config.getInstancia();
        config2.setIdioma("inglês");

        System.out.println(config1.getConfiguracoes());
        System.out.println(config2.getConfiguracoes());
        System.out.println(config1 == config2);
    }
}



public class Time {

        private int id;
        private String description;
        private Boolean done;

	/*private Tarefa time;
	private <List> lista;*/

        @Override
        public String toString() {
            return "Tarefa [Id=" + id + ", Descrição=" + description + ", Estado=" + done + "]";
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDescricao() {
            return description;
        }

        public void setDescricao(String descricao) {
            this.description = descricao;
        }

        public Boolean getEstado() {
            return done;
        }

        public void setEstado(Boolean estado) {

        }
    }

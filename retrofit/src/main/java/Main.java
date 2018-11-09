import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class Main {
    public static void main(String args[]){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ec2-35-166-113-35.us-west-2.compute.amazonaws.com/")

                .addConverterFactory(GsonConverterFactory.create())
                .build();

        TesteApi api = retrofit.create(TesteApi.class);

        try {

            //traz todas as tarefas
            Call<List<Time>> lista = api.getTarefa();
            Response<List<Time>> responseLista = lista.execute();
            List<Time> tarefasLista = responseLista.body();
            System.out.println(tarefasLista);

            //traz 1 tarefa
            Call<Time> retornaUnico = api.getTarefa(33);
            Response<Time> responseUnico = retornaUnico.execute();
            Time tarefasUnico = responseUnico.body();
            System.out.println(tarefasUnico);

            //edita tarefa
            Time tarefaEdita = new Time();
            tarefaEdita.setDescricao("face");
            tarefaEdita.setEstado(true);
            Call<Void> editaTarefa = api.SetTarefa(562, tarefaEdita);
            Response responseEdita = editaTarefa.execute();
            responseEdita.isSuccessful();
            if (responseEdita.isSuccessful()){
                System.out.println("Tarefa editada");
            }

            /*
            //Cria tarefa
            Time tarefaCria = new Time();
            tarefaCria.setDescricao("Aprendendo algo");
            tarefaCria.setEstado(true);
            Call<Time> criaTarefa = api.setTarefa(tarefaCria);
            Response<Time> responseCria = criaTarefa.execute();
            Time tarefasCria = responseCria.body();
            responseCria.isSuccessful();
            if (responseCria.isSuccessful()){
                System.out.println("Tarefa criada");
            }
            */
            // Deleta tarefa
            Call<Void> deletaTarefa = api.delTarefa(1341);
            Response<Void> responseTarefa = deletaTarefa.execute();
            responseTarefa.isSuccessful();
            if (responseTarefa.isSuccessful()){
                System.out.println("Tarefa deletada");
            }

        }catch(Exception e) {
            e.printStackTrace();
        }

    }
}

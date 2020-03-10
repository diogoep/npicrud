<template>
  <div>
    <v-card-widget enableActions :title="'Página Inicial'">
      <div slot="widget-header-action">

      </div>
      <div slot="widget-content">
        <v-row>
          <v-col cols="12">
            <v-data-table
                    :headers="headers"
                    :items="cursos"
                    :items-per-page="5"
                    class="elevation-1"
            >
              <template v-slot:item.action="{ item }">
                <v-btn icon :to="{path: 'editCurso/'+item.id}" color="primary" dark>
                  <v-icon small>
                    mdi-pencil
                  </v-icon>
                </v-btn>
                <v-btn icon :to="{path: 'deleteCurso/'+item.id}" color="primary" dark>
                  <v-icon small @click="remove(item)">  
                    mdi-delete
                  </v-icon>
                </v-btn>
              </template>
            </v-data-table> 
          </v-col>
        </v-row>
        <v-btn raised to="/formCurso" color="primary" dark>Adicionar Curso</v-btn>
      </div>
      
    </v-card-widget>
  
  </div>
  
</template>

<script>
// @ is an alias to /src
import VCardWidget from "@/components/VWidget";
import {RepositoryFactory} from "@/repositories/RepositoryFactory";
const cursoRepo = RepositoryFactory.get("curso");
import axios from 'axios';

export default {
  name: 'homeCursos',
  components: {
    VCardWidget
  },

  data: () => ({
    headers: [
      {
        text: 'Nome',
        align: 'left',
        value: 'nome',
      },
      { text: 'Sigla', value: 'sigla' },
      { text: 'Turno', value: 'turno' },
      { text: 'Ações', value: 'action', sortable: false }
    ],
    cursos :[]
  }),

  created() {
    cursoRepo.getAll().then(res => {
      this.cursos = res.data;
    }).catch(console.error);
  },

  computed: {

  },

  methods: {
 remove: function(item){
                      this.$store.dispatch('remove/removeCurso', {id: item.id})
                        .then(() => {
                                this.$router.push('/cursos')
                        })
    }
  }
}
</script>

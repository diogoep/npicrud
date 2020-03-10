<template>
    <v-container fluid class="fill-height">
        <v-row align="center" justify="center">
            <v-col cols="12" sm="8" md="4" >
                <v-card class="elevation-12">
                    <v-toolbar color="primary" dark flat>
                        <v-toolbar-title>Adicionar Curso</v-toolbar-title>
                    </v-toolbar>
                    <v-form @submit.prevent="onSubmit" ref="form" lazy-validation v-model="valid">
                        <v-card-text>
                            <p class="error--text text-center">{{error}}</p>
                            <v-text-field label="nome" name="nome"  type="text" v-model="nome" required :rules="requiredRule"/>
                            <v-text-field label="sigla" name="sigla"  type="text" v-model="sigla" required :rules="requiredRule"/>
                            <v-container fluid>
                                <v-col class="d-flex" cols="12" sm="6">
                                    <v-select
                                    :items="items"
                                    name="turno"
                                    label="Turno"
                                    outlined v-model="turno"
                                    ></v-select>
                                </v-col>     
                            </v-container> 
                        </v-card-text>
                        <v-card-actions>
                            <v-spacer />
                            <v-btn color="primary" type="submit" :loading="loading" large>Entrar</v-btn>
                        </v-card-actions>
                    </v-form>
                </v-card>
            </v-col>
        </v-row>
    </v-container>
</template>

<script>
    import { mapGetters, mapState } from 'vuex'
    import axios from 'axios'
    export default {
        props: ["to", "invalidToken"],
        data: () => ({
            items: ['Manhã', 'Tarde', 'Noite'],
            valid: true,
            loading: false,
            sigla:'',
            nome: '',
            turno: 'Manhã',
            error: '',
            requiredRule: [
                v => !!v || 'Campo obrigatório'
            ],
            emailRules: [ 
                v => !v || /^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$/.test(v) || 'E-mail inválido',
                v => !!v || 'Campo obrigatório'
            ]
        }),
        created() {
            if (this.invalidToken) {
                this.error = 'Sua sessão expirou. Faça login novamente'
            }
        },
        methods: {
            onSubmit () {
                this.loading = true
                if (this.$refs.form.validate()) {
                    this.$store.dispatch('create/formCurso', {sigla: this.sigla, turno: this.turno, nome: this.nome})
                        .then(() => {
                                this.$router.push('/cursos')
                        })
                }

                this.loading = false
            }
        },
        computed: {
            ...mapState({
                token: state => state.auth.token
            })
        }
    };
</script>

<style scoped lang="css">

</style>

<template>
    <v-container fluid class="fill-height">
        <v-row align="center" justify="center">
            <v-col cols="12" sm="8" md="4" >
                <v-card class="elevation-12">
                    <v-toolbar color="primary" dark flat>
                        <v-toolbar-title>Adicionar Usuário</v-toolbar-title>
                    </v-toolbar>
                    <v-form @submit.prevent="onSubmit" ref="form" lazy-validation v-model="valid">
                        <v-card-text>
                            <div id="msgemail"></div>
                            <p class="error--text text-center">{{error}}</p>
                            <v-text-field label="nome" name="nome" prepend-icon="person" type="text" v-model="nome" required :rules="requiredRule"/>
                            <v-text-field label="email" name="email" prepend-icon="email" type="text" v-model="email" required :rules="emailRules"/>
                            <v-text-field label="password" name="password" prepend-icon="lock" type="text" v-model="password" required :rules="requiredRule"/>             
                            <v-container fluid>
                                <v-checkbox id="checkbox" v-model="checked" :label="`Habilitado: ${checked.toString()}`"></v-checkbox>
                            </v-container> 
                            <v-container fluid>
                                <v-col class="d-flex" cols="12" sm="6">
                                    <v-select
                                    :items="cursos"
                                    name="curso"
                                    label="Curso"
                                    outlined v-model="curso"
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
    import { mapGetters, mapState } from 'vuex';
    import axios from 'axios';
    import {RepositoryFactory} from "@/repositories/RepositoryFactory";
    const cursoRepo = RepositoryFactory.get("curso");
    export default {
        props: ["to", "invalidToken"],
        data: () => ({
            valid: true,
            loading: false,
            email: '',
            password: '',
            nome: '',
            checked: false,
            error: '',
            requiredRule: [
                v => !!v || 'Campo obrigatório'
            ],
            emailRules: [ 
                v => !v || /^\w+([.-]?\w+)*@\w+([.-]?\w+)*(\.\w{2,3})+$/.test(v) || 'E-mail inválido',
                v => !!v || 'Campo obrigatório'
            ],
            cursos :[]
        }),
        created() {
            cursoRepo.getAll().then(res => {
            this.cursos = res.data;
            }).catch(console.error);
            if (this.invalidToken) {
                this.error = 'Sua sessão expirou. Faça login novamente'
            }
        },
        methods: {
            onSubmit () {
                this.loading = true
                if (this.$refs.form.validate()) {
                    this.$store.dispatch('create/formUsuario', {email: this.email, password: this.password, nome: this.nome, checked : this.checked})
                        .then(() => {
                                this.$router.push('/')
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

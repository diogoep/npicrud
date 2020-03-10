import store from '../store'
import LoginPage from '../views/Login'
import Home from '../views/Home'
import FormUser from '../views/FormUser'
import EditUser from '../views/EditUser'
import FormCurso from '../views/FormCurso'
import EditCurso from '../views/EditCurso'
import HomeCursos from '../views/HomeCursos'
export default [


    /* Geral */
    {
        path: '/',
        name: 'Home',
        component: Home
    },
    {
        path: '/cursos',
        name: 'HomeCursos',
        component: HomeCursos
    },
    {
        path: '/login',
        meta: {
            public: true,
        },
        props: true,
        name: 'Login',
        component: LoginPage
    },

    {
        path: '/logout',
        meta: { breadcrumb: true },
        name: 'Logout',
        beforeEnter (to, from, next) {
            store.dispatch('auth/logout', false)
        }
    },
    {
        path: '/formUsuario',
        name: 'Create User',
        component: FormUser
    },
    {
        path: '/editUsuario/:email',
        name: 'Edit User',
        component: EditUser
    },
    {
        path: '/removerUsuario/:email',
        meta: { breadcrumb: true },
        name: 'Remove User',
        beforeEnter (to, from, next) {
            store.dispatch('remove/removeUsuario', false)
        }
    },
    {
        path: '/formCurso',
        name: 'Create Course',
        component: FormCurso
    },
    {
        path: '/editCurso/:id',
        name: 'Edit Course',
        component: EditCurso
    },
    {
        path: '/removeCurso/:id',
        meta: { breadcrumb: true },
        name: 'Remove Course',
        beforeEnter (to, from, next) {
            store.dispatch('remove/removeCurso', false)
        }
    }
];

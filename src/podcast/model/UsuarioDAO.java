/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package podcast.model;

/**
 *
 * @author agnal
 */
public class UsuarioDAO {
     public Usuario validaLogin(String loginForm, String senhaForm) {

        EntityManager em = JPA.getEntityManager();
        Usuario user = null;

        try {

            String queryJPQL = "SELECT u FROM Usuario u"
                    + " WHERE u.login=:nomePar AND u.senha= :senhaPar";

            TypedQuery<Usuario> consulta = em.createQuery(queryJPQL, Usuario.class);
            consulta.setParameter("nomePar", loginForm);
            consulta.setParameter("senhaPar", senhaForm);

            if (loginForm.equals(consulta.getSingleResult().getLogin()) && senhaForm.equals(consulta.getSingleResult().getSenha())) {
                user = consulta.getSingleResult();
            }

        } finally {
            JPA.closeEtityManager();
        }

        return user;

    }
}

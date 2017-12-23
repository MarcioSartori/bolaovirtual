package br.com.zimmermann.bolaovirtual.filtros;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import org.hibernate.Session;
import br.com.zimmermann.bolaovirtual.persistencias.HibernateUtil;

public class FiltroTransacoesHibernate implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        Session sessao = HibernateUtil.getSessionFactory().getCurrentSession();
        sessao.beginTransaction();
        try {
            chain.doFilter(request, response);
            sessao.getTransaction().commit();
        } catch(Exception e) {
            sessao.getTransaction().rollback();
        }
    }

    @Override
    public void destroy() {
    }
    
}

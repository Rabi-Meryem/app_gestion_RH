package service;

import dao.EmployeDAO;
import model.Employe;

import java.util.List;

public class AuthService {

    private final EmployeDAO employeDAO = new EmployeDAO();

    public boolean authenticate(String email, String password, String role) {
        try {
            System.out.println("🔐 Tentative d'authentification - Email: " + email + ", Rôle: " + role);
            System.out.println("🔑 Mot de passe fourni: '" + password + "'");
            
            // Get all employees
            List<Employe> employees = employeDAO.getAllEmployes();
            System.out.println("👥 Nombre d'employés dans la base: " + employees.size());
            
            // List all employees for debugging
            for (Employe emp : employees) {
                System.out.println("📋 Employé trouvé: " + emp.getEmail() + " | Rôle: " + emp.getRole() + " | MP: '" + emp.getPassword() + "'");
            }
            
            // Find user by email and role
            for (Employe emp : employees) {
                if (emp.getEmail().equalsIgnoreCase(email) && 
                    emp.getPassword().equals(password) && 
                    emp.getRole().equalsIgnoreCase(role)) {
                    
                    System.out.println("✅ Utilisateur trouvé et authentifié: " + emp.getNom() + " " + emp.getPrenom());
                    return true;
                }
            }
            
            System.out.println("❌ Aucun utilisateur trouvé avec ces identifiants");
            return false;
            
        } catch (Exception e) {
            System.err.println("❌ Erreur lors de l'authentification: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

 
        
    }

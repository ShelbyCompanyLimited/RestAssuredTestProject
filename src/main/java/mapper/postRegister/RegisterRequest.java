package mapper.postRegister;

public class RegisterRequest {

        public static Builder builder() { return new Builder(); }
        private String email;
        private String password;


        public String getEmail() {
            return email;
        }
        public String getPassword() {
            return password;
        }


    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public static class Builder {
        private String email;
        private String password;

        public Builder withEmail(String email){
            this.email = email;
            return this;
        }

        public Builder withPassword(String password){
            this.password = password;
            return this;
        }

        public RegisterRequest createInstance(){

            final RegisterRequest registerRequest = new RegisterRequest();

            registerRequest.setEmail(email);
            registerRequest.setPassword(password);
            return registerRequest;

        }

    }


}

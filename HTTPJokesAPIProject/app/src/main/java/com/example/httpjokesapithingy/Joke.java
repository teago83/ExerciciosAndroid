package com.example.httpjokesapithingy;

public class Joke {

    private String Category;
    private String Type;
    private String Setup;
    private String Delivery;
    private String Nsfw;
    private String Religious;
    private String Political;
    private String Racist;
    private String Sexist;
    private String Id;

    public String GetCategory () { return Category; }
    public void SetCategory (String Category) { this.Category = Category; }

    public String GetType () { return Type; }
    public void SetType (String Type) { this.Type = Type; }

    public String GetSetup () { return Setup; }
    public void SetSetup (String Setup) { this.Setup = Setup; }

    public String GetDelivery () { return Delivery; }
    public void SetDelivery (String Delivery) { this.Delivery = Delivery; }

    public String GetNsfw () { return Nsfw; }
    public void SetNsfw (String Nsfw) { this.Nsfw = Nsfw; }

    public String GetReligious () { return Religious; }
    public void SetReligious (String Religious) { this.Religious = Religious; }

    public String GetPolitical () { return Political; }
    public void SetPolitical (String Political) { this.Political = Political; }

    public String GetRacist () { return Racist; }
    public void SetRacist (String Racist) { this.Racist = Racist; }

    public String GetSexist () { return Sexist; }
    public void SetSexist (String Sexist) { this.Sexist = Sexist; }

    public String GetId () { return Id; }
    public void SetId (String Id) { this.Id = Id; }
}

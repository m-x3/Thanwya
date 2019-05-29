
package com.examplcoue.mazen.thanwya;

import com.backendless.Backendless;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.DataQueryBuilder;

import java.util.List;

public class Droos
{
  private java.util.Date updated;
  private String Info;
  private java.util.Date created;
  private String Name;
  private String objectId;
  private String ownerId;
  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getInfo()
  {
    return Info;
  }

  public void setInfo( String Info )
  {
    this.Info = Info;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public String getName()
  {
    return Name;
  }

  public void setName( String Name )
  {
    this.Name = Name;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

                                                    
  public Droos save()
  {
    return Backendless.Data.of( Droos.class ).save( this );
  }

  public void saveAsync( AsyncCallback<Droos> callback )
  {
    Backendless.Data.of( Droos.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Droos.class ).remove( this );
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Droos.class ).remove( this, callback );
  }

  public static Droos findById( String id )
  {
    return Backendless.Data.of( Droos.class ).findById( id );
  }

  public static void findByIdAsync( String id, AsyncCallback<Droos> callback )
  {
    Backendless.Data.of( Droos.class ).findById( id, callback );
  }

  public static Droos findFirst()
  {
    return Backendless.Data.of( Droos.class ).findFirst();
  }

  public static void findFirstAsync( AsyncCallback<Droos> callback )
  {
    Backendless.Data.of( Droos.class ).findFirst( callback );
  }

  public static Droos findLast()
  {
    return Backendless.Data.of( Droos.class ).findLast();
  }

  public static void findLastAsync( AsyncCallback<Droos> callback )
  {
    Backendless.Data.of( Droos.class ).findLast( callback );
  }

  public static List<Droos> find( DataQueryBuilder queryBuilder )
  {
    return Backendless.Data.of( Droos.class ).find( queryBuilder );
  }

  public static void findAsync( DataQueryBuilder queryBuilder, AsyncCallback<List<Droos>> callback )
  {
    Backendless.Data.of( Droos.class ).find( queryBuilder, callback );
  }
}
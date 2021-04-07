package tn.esprit.spring.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="path")
public class Path implements Serializable{
	
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="Path_id")
		private Long id;
		@Column
		private String distance;
		@Column
		private String route;
		
		
		public Path(Long id, String distance, String route) {
			super();
			this.id = id;
			this.distance = distance;
			this.route = route;
			
		}
		public Path() {
		
		}
		
		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getDistance() {
			return distance;
		}
		public void setDistance(String distance) {
			this.distance = distance;
		}
		public String getRoute() {
			return route;
		}
		public void setRoute(String route) {
			this.route = route;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((distance == null) ? 0 : distance.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((route == null) ? 0 : route.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Path other = (Path) obj;
			if (distance == null) {
				if (other.distance != null)
					return false;
			} else if (!distance.equals(other.distance))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (route == null) {
				if (other.route != null)
					return false;
			} else if (!route.equals(other.route))
				return false;
			return true;
		}
		@Override
		public String toString() {
			return "Path [id=" + id + ", distance=" + distance + ", route=" + route + ", getId()=" + getId()
					+ ", getDistance()=" + getDistance() + ", getRoute()=" + getRoute() + ", hashCode()=" + hashCode()
					+ "]";
		}
		
}

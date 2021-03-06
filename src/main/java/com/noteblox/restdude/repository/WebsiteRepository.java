/**
 * This file is part of NoteBLOX.
 *
 * NoteBLOX is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * NoteBLOX is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with NoteBLOX.  If not, see <https://www.gnu.org/licenses/agpl-3.0.en.html>.
 */
package com.noteblox.restdude.repository;

import com.noteblox.restdude.model.Website;
import com.noteblox.restdude.model.WebsiteNotesApp;
import com.restdude.domain.misc.model.Host;
import com.restdude.mdd.repository.ModelRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface WebsiteRepository extends ModelRepository<Website, String> {

    @Query("select w from Website w where w.host = ?2 and ?1 like CONCAT(w.basePath, '%') order by w.basePath DESC")
    public Optional<Website> findByPathAndHost(String path, Host host);
}

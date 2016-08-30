create index IX_CC364112 on jukebox_Album (artistId);
create index IX_10F3E3CC on jukebox_Album (companyId);
create index IX_B018C3EA on jukebox_Album (groupId, artistId, status);
create index IX_925AEC73 on jukebox_Album (groupId, name[$COLUMN_LENGTH:75$], status);
create index IX_B355FE34 on jukebox_Album (groupId, status);
create index IX_54D51788 on jukebox_Album (groupId, userId);
create index IX_4BA43B16 on jukebox_Album (userId);
create index IX_553881D0 on jukebox_Album (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_17973C52 on jukebox_Album (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_4751EEA2 on jukebox_Artist (companyId);
create index IX_AB816649 on jukebox_Artist (groupId, name[$COLUMN_LENGTH:75$], status);
create index IX_61FA108A on jukebox_Artist (groupId, status);
create index IX_C96764AA on jukebox_Artist (userId, groupId);
create index IX_7B16BA3A on jukebox_Artist (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_A99C873C on jukebox_Artist (uuid_[$COLUMN_LENGTH:75$], groupId);

create index IX_F87579AC on jukebox_Song (albumId, status);
create index IX_DBB74E8A on jukebox_Song (artistId);
create index IX_F1948554 on jukebox_Song (companyId);
create index IX_BA643F6A on jukebox_Song (groupId, albumId, status);
create unique index IX_93382CCD on jukebox_Song (groupId, artistId, albumId, name[$COLUMN_LENGTH:75$]);
create index IX_9FAD81FB on jukebox_Song (groupId, name[$COLUMN_LENGTH:75$], status);
create index IX_818959BC on jukebox_Song (groupId, status);
create index IX_23087310 on jukebox_Song (groupId, userId);
create index IX_387A468E on jukebox_Song (userId);
create index IX_4D709748 on jukebox_Song (uuid_[$COLUMN_LENGTH:75$], companyId);
create unique index IX_3F464FCA on jukebox_Song (uuid_[$COLUMN_LENGTH:75$], groupId);